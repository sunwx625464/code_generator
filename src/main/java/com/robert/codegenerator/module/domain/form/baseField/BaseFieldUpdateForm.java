package com.robert.codegenerator.module.domain.form.baseField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sunweixin
 * @date 2024/7/24
 * @description 基础字段修改form
 */
@Data
@ApiModel(value = "基础字段修改form",description = "基础字段修改form")
public class BaseFieldUpdateForm {

    @ApiModelProperty("id")
    @NotNull(message = "id不能为空")
    private Long id;

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
