package com.caomu.demo.controller;

import com.caomu.demo.service.RoleService;
import com.caomu.demo.vo.RoleListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色控制器
 *
 * @author 刘斌
 */
@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {this.roleService = roleService;}

    /**
     * 获取全部role list
     *
     * @return list
     */
    @GetMapping("getAllRole")
    public List<RoleListVo> getAllRole() {

        return roleService.list()
                          .stream()
                          .map(item -> {
                              final RoleListVo vo = new RoleListVo();
                              BeanUtils.copyProperties(item, vo);
                              return vo;
                          })
                          .collect(Collectors.toList());
    }

}
