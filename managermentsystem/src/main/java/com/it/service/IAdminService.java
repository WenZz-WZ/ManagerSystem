package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.Admin;

public interface IAdminService extends IService<Admin> {
    Admin login(Admin admin);
}
