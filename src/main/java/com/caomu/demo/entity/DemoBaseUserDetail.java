package com.caomu.demo.entity;

import com.caomu.bootstrap.domain.BaseUserDetail;

/**
 * 演示 的用户信息
 *
 * @author 刘斌
 */
public class DemoBaseUserDetail extends BaseUserDetail {
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
}
