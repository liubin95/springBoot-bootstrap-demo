package com.caomu.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caomu.demo.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author 刘斌
 * @since 2020-12-14
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

}
