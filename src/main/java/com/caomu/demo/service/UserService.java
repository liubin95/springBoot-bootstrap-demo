package com.caomu.demo.service;

import com.caomu.bootstrap.service.BaseService;
import com.caomu.demo.entity.UserEntity;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-16
 */
public interface UserService extends BaseService<UserEntity> {

    /**
     * 模拟登陆
     *
     * @param userEntity 实体
     * @return token
     */
    String login(UserEntity userEntity);
}
