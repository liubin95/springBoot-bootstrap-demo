package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@TableName("auth")
public class AuthEntity extends BaseEntity {

    public static final String AUTH_NAME = "auth_name";
    public static final String AUTH_CODE = "auth_code";
    private static final long serialVersionUID = 1L;
    /**
     * 权限名
     */
    private String authName;
    /**
     * 标识符-对应接口的权限
     */
    private String authCode;

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

}
