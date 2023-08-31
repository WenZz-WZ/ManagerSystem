package com.it.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("d_admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @ApiModelProperty(value = "管理员id")
    private Integer a_id;
    @ApiModelProperty(value = "管理员账号")
    @TableField(value = "a_username")
    private String username;
    @ApiModelProperty(value = "管理员密码")
    @TableField(value = "a_password")
    private String password;

    private String a_name;
    private Integer a_phone;
    private String a_power;
    private String a_describe;

}
