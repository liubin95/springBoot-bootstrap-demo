package com.caomu.demo.vo;

import java.io.Serializable;

/**
 * @author admin
 */
public class MenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long pid;

    private String menuName;

    private String menuUrl;

    /**
     * 菜单icon
     */
    private String menuIcon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

}
