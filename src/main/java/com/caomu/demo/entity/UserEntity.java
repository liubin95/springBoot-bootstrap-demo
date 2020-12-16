package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-16
 */
@TableName("user")
public class UserEntity extends BaseEntity {

    public static final String NICK_NAME = "nick_name";

    public static final String LOGIN_NAME = "login_name";

    public static final String PASSWORD = "password";

    public static final String ROLE_ID = "role_id";

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @NotBlank(message = "【userLoginName】 不能为空",
              groups = {Login.class, Add.class})
    private String loginName;

    /**
     * 名称
     */
    private String nickName;

    /**
     * 密码
     */
    @NotBlank(message = "【password】 不能为空",
              groups = {Login.class, Add.class})
    private String password;

    /**
     * 角色id
     */
    @NotNull(message = "【roleId】 不能为空",
             groups = Add.class)
    private Long roleId;

    public Long getRoleId() {

        return roleId;
    }

    public void setRoleId(Long roleId) {

        this.roleId = roleId;
    }

    public String getLoginName() {

        return loginName;
    }

    public void setLoginName(String loginName) {

        this.loginName = loginName;
    }

    public String getNickName() {

        return nickName;
    }

    public void setNickName(String nickName) {

        this.nickName = nickName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public interface Login {

    }

    public interface Add {

    }

}
