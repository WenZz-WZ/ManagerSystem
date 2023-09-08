package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.Menu;
import com.it.mapper.MenuMapper;
import com.it.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenus() {
        return menuMapper.getMenus();
    }
}
