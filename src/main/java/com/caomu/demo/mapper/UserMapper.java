package com.caomu.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caomu.demo.entity.UserEntity;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 刘斌
 * @since 2020-11-16
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
