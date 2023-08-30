package com.it.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("d_admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Integer a_id;
    private String a_username;
    private String a_password;
    private String a_name;
    private Integer a_phone;
    private String a_power;
    private String a_describe;

}
