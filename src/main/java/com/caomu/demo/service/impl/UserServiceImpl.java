package com.caomu.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caomu.bootstrap.config.BusinessRuntimeException;
import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.entity.UserEntity;
import com.caomu.demo.mapper.UserMapper;
import com.caomu.demo.service.UserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-16
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService {

    @Resource
    private TokenUtil<UserEntity> userEntityTokenUtil;

    @Resource
    private UserMapper userMapper;

    @Override
    public String login(UserEntity userEntity) {
        final QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq(UserEntity.USER_LOGIN_NAME, userEntity.getUserLoginName());
        final UserEntity entity = userMapper.selectOne(userEntityQueryWrapper);
        if (entity == null) {
            throw new BusinessRuntimeException("用户名密码错误。");
        }
        // 省略密码之类的
        return userEntityTokenUtil.generateToken(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transactional() {
        final UserEntity entity = userEntityTokenUtil.resolveToken(getToken());
        entity.setUserName("事务修改第一条");
        this.updateById(entity);
        this.transactionalSon(entity);
    }

    public void transactionalSon(UserEntity entity) {
        entity.setUserLoginName("demoData1");
        this.updateById(entity);
    }
}
