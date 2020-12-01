package com.caomu.demo.service.impl;

import org.springframework.stereotype.Service;

import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.demo.entity.AuthEntity;
import com.caomu.demo.mapper.AuthMapper;
import com.caomu.demo.service.AuthService;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@Service
public class AuthServiceImpl extends BaseServiceImpl<AuthMapper, AuthEntity> implements AuthService {

}
