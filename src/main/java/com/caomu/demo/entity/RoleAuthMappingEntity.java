package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

/**
 * <p>
 * 角色和权限映射表
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@TableName("role_auth_mapping")
public class RoleAuthMappingEntity extends BaseEntity {

    public static final String ROLE_ID = "role_id";
    public static final String AUTH_ID = "auth_id";
    private static final long serialVersionUID = 1L;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long authId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }
}
