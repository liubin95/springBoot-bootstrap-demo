package com.caomu.demo.service;

import com.caomu.bootstrap.service.BaseService;
import com.caomu.demo.entity.MenuEntity;
import com.caomu.demo.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author 刘斌
 * @since 2020-12-14
 */
public interface MenuService extends BaseService<MenuEntity> {


    /**
     * @param roleId
     * @return
     */
    List<MenuEntity> getMenuEntitiesByRoleId(Long roleId);

    /**
     * 查询子菜单
     *
     * @param pid 父级id
     * @return 集合
     */
    List<MenuVo> queryMenuSon(Long pid);

}
