package com.caomu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caomu.demo.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-27
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {

}
