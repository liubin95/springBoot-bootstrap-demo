package com.caomu.demo.service;

import com.caomu.bootstrap.service.BaseService;
import com.caomu.demo.entity.AuthEntity;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
public interface AuthService extends BaseService<AuthEntity> {


    /**
     * @param roleId
     * @return
     */
    List<AuthEntity> getAuthEntitiesByRoleId(Long roleId);

}
