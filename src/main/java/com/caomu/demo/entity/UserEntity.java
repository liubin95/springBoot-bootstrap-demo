package com.caomu.demo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;
import com.caomu.demo.enums.UserDeviceEnum;

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


    public static final String USER_NAME = "user_name";
    public static final String USER_LOGIN_NAME = "user_login_name";
    public static final String PASSWORD = "password";
    public static final String DEVICE_ID = "device_id";
    public static final String MARATHON_ID = "marathon_id";
    public static final String ROLE_ID = "role_id";
    /**
     * 账号
     */
    @NotBlank(message = "【userLoginName】 不能为空", groups = {Login.class, Add.class})
    private String userLoginName;
    /**
     * 名称
     */
    private String userName;
    /**
     * 密码
     */
    @NotBlank(message = "【password】 不能为空", groups = {Login.class, Add.class})
    private String password;
    /**
     * 设备号
     */
    @NotNull(message = "【deviceId】 不能为空", groups = Add.class)
    private UserDeviceEnum deviceId;
    /**
     * 比赛id
     */
    @NotNull(message = "【marathonId】 不能为空", groups = Add.class)
    private Long marathonId;
    /**
     * 角色id
     */
    @NotNull(message = "【roleId】 不能为空", groups = Add.class)
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDeviceEnum getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UserDeviceEnum deviceId) {
        this.deviceId = deviceId;
    }

    public Long getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(Long marathonId) {
        this.marathonId = marathonId;
    }

    public interface Login {

    }

    public interface Add {

    }
}
