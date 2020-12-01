package com.caomu.demo.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caomu.bootstrap.domain.BaseUserDetail;
import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.entity.AuthEntity;
import com.caomu.demo.entity.DemoBaseUserDetail;
import com.caomu.demo.entity.RoleAuthMappingEntity;
import com.caomu.demo.entity.UserEntity;
import com.caomu.demo.mapper.AuthMapper;
import com.caomu.demo.mapper.RoleAuthMappingMapper;
import com.caomu.demo.mapper.UserMapper;
import com.caomu.demo.service.UserService;

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

    @Resource
    private TokenUtil<UserEntity> userEntityTokenUtil;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleAuthMappingMapper roleAuthMappingMapper;

    @Resource
    private AuthMapper authMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactional() {
        final UserEntity entity = getById(1333590744960049154L);
        entity.setUserName("事务修改第一条");
        this.updateById(entity);
        this.transactionalSon(entity);
    }

    public void transactionalSon(UserEntity entity) {
        entity.setUserLoginName("demoData1");
        this.updateById(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq(UserEntity.USER_LOGIN_NAME, username);
        final UserEntity entity = userMapper.selectOne(userEntityQueryWrapper);
        if (entity == null) {
            throw new UsernameNotFoundException("用户名密码错误。");
        }
        final QueryWrapper<RoleAuthMappingEntity> roleAuthMappingEntityQueryWrapper = new QueryWrapper<>();
        roleAuthMappingEntityQueryWrapper.eq(RoleAuthMappingEntity.ROLE_ID, entity.getRoleId());
        final List<RoleAuthMappingEntity> roleAuthMappingEntities = roleAuthMappingMapper.selectList(roleAuthMappingEntityQueryWrapper);
        final Set<Long> authIdSet = roleAuthMappingEntities.stream()
                                                           .map(RoleAuthMappingEntity::getAuthId)
                                                           .collect(Collectors.toSet());
        final List<AuthEntity> authList = authMapper.selectBatchIds(authIdSet);
        final Set<GrantedAuthority> authoritySet = authList.stream()
                                                           .map(item -> (GrantedAuthority) new SimpleGrantedAuthority(item.getAuthCode()))
                                                           .collect(Collectors.toSet());
        final BaseUserDetail baseUserDetail = new DemoBaseUserDetail();
        // 在此处生成token，后续会根据token的过期时间，设置redis的过期时间
        final String token = userEntityTokenUtil.generateToken(entity);
        baseUserDetail.setToken(token);
        BeanUtils.copyProperties(entity, baseUserDetail);
        baseUserDetail.setAuthSet(authoritySet);
        return baseUserDetail;
    }
}
