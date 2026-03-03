package com.robert.codegenerator.module.domain.form.baseField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sunweixin
 * @date 2024/7/22
 * @description 基础字段新增form
 */
@Data
@ApiModel(value = "基础字段新增form",description = "基础字段新增form")
public class BaseFieldInsertForm {


    /**
     * 字段名称
     */
    @ApiModelProperty("字段名称")
    @NotBlank(message = "字段名称不能为空")
    private String fieldName;

    /**
     * 字段备注
     */
    @ApiModelProperty("字段备注")
    private String fieldRemark;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    private Integer status;


    /**
     * 字段类型
     */
    @ApiModelProperty("字段类型")
    @NotBlank(message = "字段类型不能为空")
    private String fieldType;

}
