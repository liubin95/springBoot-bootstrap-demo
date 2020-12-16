package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

/**
 * <p>
 * 角色和菜单映射表
 * </p>
 *
 * @author 刘斌
 * @since 2020-12-14
 */
@TableName("role_menu_mapping")
public class RoleMenuMappingEntity extends BaseEntity {

    public static final String ROLE_ID = "role_id";

    public static final String MENU_ID = "menu_id";

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;

    public Long getRoleId() {

        return roleId;
    }

    public void setRoleId(Long roleId) {

        this.roleId = roleId;
    }

    public Long getMenuId() {

        return menuId;
    }

    public void setMenuId(Long menuId) {

        this.menuId = menuId;
    }

}
