package com.caomu.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.caomu.bootstrap.config.BusinessRuntimeException;
import com.caomu.bootstrap.domain.BaseUserDetail;
import com.caomu.bootstrap.domain.Page;
import com.caomu.demo.entity.UserEntity;
import com.caomu.demo.query.IdQuery;
import com.caomu.demo.service.UserService;
import com.caomu.demo.vo.UserVo;
import org.redisson.api.RMapCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 例子控制器
 *
 * @author 刘斌
 */
@RestController
@RequestMapping("user")
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private RMapCache<Long, BaseUserDetail> authIdUserMap;


    /**
     * 新增演示
     *
     * @param userEntity 对象
     */
    @PostMapping("add")
    public void add(@Validated(UserEntity.Add.class) @RequestBody UserEntity userEntity) {

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userService.save(userEntity);
    }

    /**
     * 刷新token
     *
     * @return token
     */
    @GetMapping("refreshToken")
    public String refreshToken() {

        final Object principal = SecurityContextHolder.getContext()
                                                      .getAuthentication()
                                                      .getPrincipal();
        LOGGER.info(principal.toString());
        return "";
    }

    /**
     * 强制用户下线
     *
     * @param idQuery id
     */
    @GetMapping("logoutUser")
    public void logoutUser(@Validated IdQuery idQuery) {

        authIdUserMap.remove(idQuery.getId());
    }

    /**
     * 不需要登录的接口
     *
     * @return 字符串
     */
    @GetMapping("noLogin")
    public String noLogin() {
        throw new RuntimeException("");
    }

    /**
     * 逻辑删除演示
     *
     * @param idQuery id
     */
    @GetMapping("delete")
    @PreAuthorize("hasAuthority('OP::USER::DELETE')")
    public void delete(@Validated IdQuery idQuery) {

        if (idQuery.getId()
                   .equals(1L)) {
            throw new BusinessRuntimeException("删除失败");
        }
        if (!userService.removeById(idQuery.getId())) {
            throw new BusinessRuntimeException("删除失败");
        }
    }

    /**
     * 分页 排序 检索（你好%）
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @PostMapping("page")
    //    @PreAuthorize("hasAuthority('MENU::USER::LIST')")
    public IPage<UserVo> page(@RequestBody Page<UserEntity> page) {

        return userService.pageAndSearchUser(page);
    }


}
