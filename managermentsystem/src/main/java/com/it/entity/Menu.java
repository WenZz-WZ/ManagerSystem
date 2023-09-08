package com.it.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "menu对象")
// @Alias("Menu")
@TableName("d_menu")
public class Menu {

    @ApiModelProperty(value = "id")
    @TableField(value = "id")
    private Integer id;

    @ApiModelProperty(value = "权限ID")
    private Integer pid;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "path")
    private String path;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<Menu> children;

}
