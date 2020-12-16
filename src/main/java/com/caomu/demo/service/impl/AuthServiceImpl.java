package com.caomu.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caomu.bootstrap.service.BaseServiceImpl;
import com.caomu.demo.entity.AuthEntity;
import com.caomu.demo.entity.RoleAuthMappingEntity;
import com.caomu.demo.mapper.AuthMapper;
import com.caomu.demo.mapper.RoleAuthMappingMapper;
import com.caomu.demo.service.AuthService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    private final AuthMapper authMapper;


    private final RoleAuthMappingMapper roleAuthMappingMapper;

    public AuthServiceImpl(AuthMapper authMapper,
                           RoleAuthMappingMapper roleAuthMappingMapper) {
        this.authMapper            = authMapper;
        this.roleAuthMappingMapper = roleAuthMappingMapper;
    }

    @Override
    public List<AuthEntity> getAuthEntitiesByRoleId(Long roleId) {
        // 获取权限
        final QueryWrapper<RoleAuthMappingEntity> roleAuthMappingEntityQueryWrapper = new QueryWrapper<>();
        roleAuthMappingEntityQueryWrapper.eq(RoleAuthMappingEntity.ROLE_ID, roleId);
        final List<RoleAuthMappingEntity> roleAuthMappingEntities = roleAuthMappingMapper.selectList(roleAuthMappingEntityQueryWrapper);
        final Set<Long> authIdSet = roleAuthMappingEntities.stream()
                                                           .map(RoleAuthMappingEntity::getAuthId)
                                                           .collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(authIdSet)) {
            return new ArrayList<>();
        }
        return authMapper.selectBatchIds(authIdSet);
    }

}
