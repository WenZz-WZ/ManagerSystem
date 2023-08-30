package com.it.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "d_class")
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    private  Integer c_id;
    private  Integer c_classid;
    private  String  c_classname;
    private  String  c_counsellor;

}
