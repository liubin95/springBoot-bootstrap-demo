package com.caomu.demo.entity;

import javax.validation.constraints.NotBlank;

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

    public interface Login {

    }

    private String userName;

    /**
     * 账号
     */
    @NotBlank(message = "【userLoginName】 不能为空", groups = Login.class)
    private String userLoginName;

    /**
     * 密码
     */
    @NotBlank(message = "【password】 不能为空", groups = Login.class)
    private String password;


    /**
     * 设备号
     */
    private UserDeviceEnum deviceId;

    /**
     * 比赛id
     */
    private Long marathonId;


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
}
