package com.it.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.Admin;
import com.it.mapper.AdminMapper;
import com.it.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {

        String password = SecureUtil.md5(admin.getPassword());

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, admin.getUsername());
        queryWrapper.eq(Admin::getPassword, password);
        Admin user = adminMapper.selectOne(queryWrapper);
        if (null == user) {
            return null;
        }

        return user;
    }
}
