package com.caomu.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caomu.bootstrap.domain.Page;
import com.caomu.bootstrap.service.BaseService;
import com.caomu.demo.entity.UserEntity;
import com.caomu.demo.vo.UserVo;

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
     * 获取用户的分页
     *
     * @param page 包括搜索、筛选、排序
     * @return 对象
     */
    IPage<UserVo> pageAndSearchUser(Page<UserEntity> page);

}
