package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author 刘斌
 * @since 2020-12-14
 */
@TableName("menu")
public class MenuEntity extends BaseEntity {

    public static final String MENU_NAME = "menu_name";

    public static final String MENU_URL = "menu_url";

    public static final String MENU_CODE = "menu_code";

    public static final String MENU_ICON = "menu_icon";

    public static final String PID = "pid";

    private static final long serialVersionUID = 1L;

    /**
     * 父级id
     */
    private Long pid;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 路由-前端对应的路由
     */
    private String menuUrl;

    /**
     * 标识符
     */
    private String menuCode;

    /**
     * 菜单icon
     */
    private String menuIcon;

    public String getMenuName() {

        return menuName;
    }

    public void setMenuName(String menuName) {

        this.menuName = menuName;
    }

    public String getMenuUrl() {

        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {

        this.menuUrl = menuUrl;
    }

    public Long getPid() {

        return pid;
    }

    public void setPid(Long pid) {

        this.pid = pid;
    }

    public String getMenuCode() {

        return menuCode;
    }

    public void setMenuCode(String menuCode) {

        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

}
