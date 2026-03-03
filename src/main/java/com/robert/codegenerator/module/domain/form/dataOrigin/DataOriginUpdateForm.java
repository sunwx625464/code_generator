package com.robert.codegenerator.module.domain.form.dataOrigin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description 数据源管理修改form
 */
@Data
@ApiModel(value = "数据源管理修改form",description = "数据源管理修改form")
public class DataOriginUpdateForm {

    /**
     * id
     */
    @ApiModelProperty("id")
    @NotNull(message = "id不能为空")
    private Long id;

    /**
     * 连接名
     */
    @ApiModelProperty("连接名")
    @NotBlank(message = "连接名不能为空")
    private String connectName;

    /**
     * 主机地址
     */
    @ApiModelProperty("主机地址")
    @NotBlank(message = "主机地址不能为空")
    private String hostname;

    /**
     * 端口
     */
    @ApiModelProperty("端口")
    @NotNull(message = "端口不能为空")
    private Integer port;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 数据库类别
     */
    @ApiModelProperty("数据库类别")
    @NotBlank(message = "数据库类别不能为空")
    private String type;
}
