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
     * @param userEntity
     * @return
     */
    String login(UserEntity userEntity);
}
