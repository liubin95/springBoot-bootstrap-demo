package com.caomu.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.demo.entity.MenuEntity;
import com.caomu.demo.entity.RoleMenuMappingEntity;
import com.caomu.demo.mapper.MenuMapper;
import com.caomu.demo.mapper.RoleMenuMappingMapper;
import com.caomu.demo.service.MenuService;
import com.caomu.demo.vo.MenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author 刘斌
 * @since 2020-12-14
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    private final RoleMenuMappingMapper roleMenuMappingMapper;

    private final MenuMapper menuMapper;

    public MenuServiceImpl(RoleMenuMappingMapper roleMenuMappingMapper,
                           MenuMapper menuMapper) {
        this.roleMenuMappingMapper = roleMenuMappingMapper;
        this.menuMapper            = menuMapper;
    }


    @Override
    public List<MenuEntity> getMenuEntitiesByRoleId(Long roleId) {
        // 获取菜单
        final QueryWrapper<RoleMenuMappingEntity> roleMenuMappingEntityQueryWrapper = new QueryWrapper<>();
        roleMenuMappingEntityQueryWrapper.eq(RoleMenuMappingEntity.ROLE_ID, roleId);
        final List<RoleMenuMappingEntity> roleMenuMappingEntities = roleMenuMappingMapper.selectList(roleMenuMappingEntityQueryWrapper);
        final Set<Long> menuIdSet = roleMenuMappingEntities.stream()
                                                           .map(RoleMenuMappingEntity::getMenuId)
                                                           .collect(Collectors.toSet());
        return menuMapper.selectBatchIds(menuIdSet);
    }

    @Override
    public List<MenuVo> queryMenuSon(Long pid) {
        final QueryWrapper<MenuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(MenuEntity.PID, pid);
        final List<MenuEntity> menuEntities = menuMapper.selectList(wrapper);
        return menuEntities.stream()
                           .map(item -> {
                               final MenuVo vo = new MenuVo();
                               BeanUtils.copyProperties(item, vo);
                               return vo;
                           })
                           .collect(Collectors.toList());
    }

}
