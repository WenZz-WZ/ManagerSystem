package com.it.controller;

import cn.hutool.core.util.StrUtil;
import com.it.dto.Result;
import com.it.entity.Admin;
import com.it.service.IAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/login")
    public Result login (@RequestBody Admin admin){

        if (StrUtil.isBlank(admin.getA_username()) || StrUtil.isBlank(admin.getA_password())) {
            return Result.error("数据输入不合法");
        }

        admin = adminService.login(admin);

        if (null == admin) {
            return Result.error("账号密码错误");
        }

        return Result.success(admin);

    }
}
