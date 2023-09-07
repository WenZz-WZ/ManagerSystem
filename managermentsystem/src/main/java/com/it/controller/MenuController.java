package com.it.controller;

import com.it.dto.Result;
import com.it.entity.Menu;
import com.it.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    @ApiOperation(value = "查询所有菜单")
    public List<Menu> getMenus() {

        List<Menu> menus = menuService.getMenus();
        return menus;
    }
}
