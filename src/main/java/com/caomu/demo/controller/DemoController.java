package com.caomu.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caomu.bootstrap.domain.Page;
import com.caomu.bootstrap.token.TokenUtil;
import com.caomu.demo.entity.UserEntity;
import com.caomu.demo.service.UserService;

/**
 * 例子控制器
 *
 * @author 刘斌
 */
@RestController
public class DemoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private TokenUtil<UserEntity> userEntityTokenUtil;


    @Resource
    private UserService userService;


    /**
     * 演示查询
     *
     * @param userEntity 用户信息
     * @return token
     */
    @PostMapping("login")
    public String login(@Validated(UserEntity.Login.class) @RequestBody UserEntity userEntity) {
        return userService.login(userEntity);
    }

    /**
     * 新增演示
     *
     * @param userEntity 对象
     */
    @PostMapping("add")
    public void add(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
    }

    /**
     * 逻辑删除演示
     *
     * @param id id
     */
    @GetMapping("delete")
    public void delete(@Valid @NotNull(message = "【id】 不能为空") Long id) {
        userService.removeById(id);
    }

    /**
     * 分页 排序 检索（你好%）
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @PostMapping("page")
    public IPage<UserEntity> page(@RequestBody Page<UserEntity> page) {
        LOGGER.debug("debug");
        return userService.pageAndSearch(page);
    }

    /**
     * 解析token的用户
     *
     * @param token token
     * @return 信息
     */
    @GetMapping("info")
    public UserEntity info(@RequestHeader String token) {
        return userEntityTokenUtil.resolveToken(token);
    }

}
