package com.caomu.demo.vo;

/**
 * @author admin
 */
public class UserVo {

    private Long id;

    /**
     * 账号
     */
    private String loginName;

    /**
     * 名称
     */
    private String nickName;

    /**
     * 角色id
     */
    private String roleName;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
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

    public String getRoleName() {

        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

}
