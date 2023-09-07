package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {
    List<Menu> getMenus();
}
