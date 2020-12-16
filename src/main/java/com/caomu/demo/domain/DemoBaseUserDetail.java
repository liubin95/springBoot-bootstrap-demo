package com.caomu.demo.domain;

import com.caomu.bootstrap.domain.BaseUserDetail;
import com.caomu.demo.vo.MenuVo;

import java.util.List;

/**
 * 演示 的用户信息
 *
 * @author 刘斌
 */
public class DemoBaseUserDetail extends BaseUserDetail {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 菜单集合
     */
    private List<MenuVo> menuList;

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    public String getNickName() {

        return nickName;
    }

    public void setNickName(String nickName) {

        this.nickName = nickName;
    }

    public List<MenuVo> getMenuList() {

        return menuList;
    }

    public void setMenuList(List<MenuVo> menuList) {

        this.menuList = menuList;
    }

}
