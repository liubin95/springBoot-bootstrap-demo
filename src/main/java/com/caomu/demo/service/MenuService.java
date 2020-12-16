package com.caomu.demo.service;

import com.caomu.bootstrap.service.BaseService;
import com.caomu.demo.entity.MenuEntity;

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

}
