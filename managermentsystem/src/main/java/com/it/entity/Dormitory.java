package com.it.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@TableName(value = "d_dormitory")
@AllArgsConstructor
@NoArgsConstructor
public class Dormitory implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer d_id;
    private  Integer s_dormitoryid;
    private  String  d_dormbuilding;
    private  String  d_bedtotal;
    private  String  d_bed;
    private  String  a_name;

}
