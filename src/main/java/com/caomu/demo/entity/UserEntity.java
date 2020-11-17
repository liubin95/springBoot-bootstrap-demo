package com.caomu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.caomu.bootstrap.domain.BaseEntity;

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


    private String userName;

    /**
     * 账号
     */
    private String userLoginName;

    /**
     * 密码
     */
    private String password;


    /**
     * 设备号
     */
    private String deviceId;

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


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(Long marathonId) {
        this.marathonId = marathonId;
    }
}
