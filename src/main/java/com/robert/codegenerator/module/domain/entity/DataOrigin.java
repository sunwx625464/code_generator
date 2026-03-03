package com.robert.codegenerator.module.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description 数据源管理
 */
@Data
@TableName(value ="data_origin")
@ApiModel(value = "数据源管理实体",description = "数据源管理实体")
public class DataOrigin implements Serializable {
    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 连接名
     */
    @ApiModelProperty("连接名")
    private String connectName;

    /**
     * 主机地址
     */
    @ApiModelProperty("主机地址")
    private String hostname;

    /**
     * 端口
     */
    @ApiModelProperty("端口")
    private Integer port;

    /**
     * 数据库名
     */
    @ApiModelProperty("数据库名")
    private String databaseName;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 逻辑删除
     */
    @ApiModelProperty("是否删除，0未删除，1删除")
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    /**
     * 数据库类别
     */
    @ApiModelProperty("数据库类别")
    private String type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}