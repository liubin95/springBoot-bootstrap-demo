package com.caomu.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caomu.bootstrap.domain.Page;
import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.domain.DemoBaseUserDetail;
import com.caomu.demo.entity.AuthEntity;
import com.caomu.demo.entity.MenuEntity;
import com.caomu.demo.entity.RoleEntity;
import com.caomu.demo.entity.UserEntity;
import com.caomu.demo.mapper.RoleMapper;
import com.caomu.demo.mapper.UserMapper;
import com.caomu.demo.service.AuthService;
import com.caomu.demo.service.MenuService;
import com.caomu.demo.service.UserService;
import com.caomu.demo.vo.MenuVo;
import com.caomu.demo.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-16
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService, UserDetailsService {

    private final TokenUtil<UserEntity> userEntityTokenUtil;

    private final UserMapper userMapper;

    private final MenuService menuService;

    private final AuthService authService;

    private final RoleMapper roleMapper;

    public UserServiceImpl(TokenUtil<UserEntity> userEntityTokenUtil,
                           UserMapper userMapper,
                           MenuService menuService,
                           AuthService authService,
                           RoleMapper roleMapper) {
        this.userEntityTokenUtil = userEntityTokenUtil;
        this.userMapper          = userMapper;
        this.menuService         = menuService;
        this.authService         = authService;
        this.roleMapper          = roleMapper;
    }


    @Override
    public IPage<UserVo> pageAndSearchUser(Page<UserEntity> page) {

        final IPage<UserVo>     result         = new Page<>();
        final IPage<UserEntity> userEntityPage = this.pageAndSearchAndFilter(page);
        final Set<Long> roleIdSet = userEntityPage.getRecords()
                                                  .stream()
                                                  .map(UserEntity::getRoleId)
                                                  .collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(roleIdSet)) {
            return result;
        }
        final Map<Long, String> roleAndRoleNameMap = roleMapper.selectBatchIds(roleIdSet)
                                                               .stream()
                                                               .collect(Collectors.toMap(RoleEntity::getId, RoleEntity::getRoleName));
        BeanUtils.copyProperties(userEntityPage, result);
        final List<UserVo> userVoList = userEntityPage.getRecords()
                                                      .stream()
                                                      .map(item -> {
                                                          final UserVo vo = new UserVo();
                                                          BeanUtils.copyProperties(item, vo);
                                                          vo.setRoleName(roleAndRoleNameMap.getOrDefault(item.getRoleId(), ""));
                                                          return vo;
                                                      })
                                                      .collect(Collectors.toList());
        result.setRecords(userVoList);
        return result;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq(UserEntity.LOGIN_NAME, username);
        final UserEntity entity = userMapper.selectOne(userEntityQueryWrapper);
        if (entity == null) {
            throw new UsernameNotFoundException("用户名密码错误。");
        }
        final Long             roleId   = entity.getRoleId();
        final List<AuthEntity> authList = authService.getAuthEntitiesByRoleId(roleId);
        final Set<GrantedAuthority> authoritySet = authList.stream()
                                                           .map(item -> (GrantedAuthority) new SimpleGrantedAuthority(item.getAuthCode()))
                                                           .collect(Collectors.toSet());
        final List<MenuEntity>      menuList    = menuService.getMenuEntitiesByRoleId(roleId);
        final Set<GrantedAuthority> menuCodeSet = new HashSet<>();
        final List<MenuVo>          menuVoList  = new ArrayList<>();
        menuList.forEach(item -> {
            final GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(item.getMenuCode());
            menuCodeSet.add(grantedAuthority);
            final MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(item, menuVo);
            menuVoList.add(menuVo);
        });
        // 把菜单的数据增加到权限
        authoritySet.addAll(menuCodeSet);
        // 创建返回对象
        final DemoBaseUserDetail baseUserDetail = new DemoBaseUserDetail();
        // 在此处生成token，后续会根据token的过期时间，设置redis的过期时间
        final String token = userEntityTokenUtil.generateToken(entity);
        baseUserDetail.setToken(token);
        BeanUtils.copyProperties(entity, baseUserDetail);
        baseUserDetail.setAuthSet(authoritySet);
        baseUserDetail.setMenuList(menuVoList);
        return baseUserDetail;
    }

}
