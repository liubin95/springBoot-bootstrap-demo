package com.caomu.demo.controller;

import com.caomu.demo.query.IdQuery;
import com.caomu.demo.service.MenuService;
import com.caomu.demo.vo.MenuVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {this.menuService = menuService;}

    /**
     * 查询树形的下级
     *
     * @param idQuery pid
     * @return 集合
     */
    @GetMapping("queryMenuSon")
    public List<MenuVo> queryMenuSon(@Validated IdQuery idQuery) {
        return menuService.queryMenuSon(idQuery.getId());
    }

}
