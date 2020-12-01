package com.caomu.demo.service.impl;

import org.springframework.stereotype.Service;

import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.demo.entity.RoleAuthMappingEntity;
import com.caomu.demo.mapper.RoleAuthMappingMapper;
import com.caomu.demo.service.RoleAuthMappingService;

/**
 * <p>
 * 角色和权限映射表 服务实现类
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@Service
public class RoleAuthMappingServiceImpl extends BaseServiceImpl<RoleAuthMappingMapper, RoleAuthMappingEntity> implements RoleAuthMappingService {

}
