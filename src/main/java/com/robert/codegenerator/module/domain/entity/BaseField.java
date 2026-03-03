package com.robert.codegenerator.module.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunweixin
 * @date 2024/7/22
 * @description 基础字段管理
 */
@Data
@TableName(value ="base_field")
@ApiModel(value = "基础字段管理实体",description = "基础字段管理实体")
public class BaseField implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键id")
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
     * 是否删除
     */
    @ApiModelProperty("是否删除，0未删除，1删除")
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用，0启用，-1未启用，默认启用")
    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    /**
     * 基础标识，用来判断是否系统内置
     */
    @ApiModelProperty("基础标识，-1系统内置，0用户创建")
    @TableField(fill = FieldFill.INSERT)
    private Integer baseFlag;

    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    private String fieldName;

    /**
     * 字段类型
     */
    @ApiModelProperty("字段类型")
    private String fieldType;

    /**
     * 字段备注
     */
    @ApiModelProperty("字段备注")
    private String fieldRemark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}