package com.caomu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caomu.demo.entity.RoleAuthMappingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色和权限映射表 Mapper 接口
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@Mapper
public interface RoleAuthMappingMapper extends BaseMapper<RoleAuthMappingEntity> {

}
