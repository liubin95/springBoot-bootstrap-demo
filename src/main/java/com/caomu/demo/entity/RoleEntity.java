package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@TableName("role")
public class RoleEntity extends BaseEntity {

    public static final String ROLE_NAME = "role_name";

    public static final String DESCRIPTION = "description";

    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

}
