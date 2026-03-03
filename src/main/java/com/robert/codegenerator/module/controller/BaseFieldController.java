package com.robert.codegenerator.module.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.robert.codegenerator.common.domain.Result;
import com.robert.codegenerator.common.enums.FeildType;
import com.robert.codegenerator.module.domain.entity.BaseField;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldInsertForm;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldUpdateForm;
import com.robert.codegenerator.module.service.BaseFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基础字段管理
 *
 * @author sunweixin
 * @date 2024/7/22
 * @description 基础字段管理
 */
@Api(tags = "基础字段管理")
@Slf4j
@RestController
@RequestMapping("/baseField")
public class BaseFieldController {


    @Resource
    private BaseFieldService baseFieldService;

    /**
     * 列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "列表查询", notes = "列表查询")
    @ApiOperationSupport(author = "sunweixin",order = 1)
    public Result<?> list(@ApiParam(value = "当前页") @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                          @ApiParam(value = "每页条数") @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                          @ApiParam(value = "状态") @RequestParam(name = "status", required = false) Integer status,
                          @ApiParam(value = "字段名称") @RequestParam(name = "fieldName", required = false) String fieldName,
                          @ApiParam(value = "字段备注") @RequestParam(name = "fieldRemark", required = false) String fieldRemark) {
        IPage<BaseField> list = baseFieldService.getList(pageNo, pageSize, status, fieldName, fieldRemark);
        return Result.OK(list);
    }


    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "新增")
    @ApiOperationSupport(author = "sunweixin",order = 2)
    public Result<?> add(@Valid @RequestBody BaseFieldInsertForm baseFieldInsertForm) {
        baseFieldService.add(baseFieldInsertForm);
        return Result.OK("新增成功");
    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    @ApiOperation(value = "修改", notes = "修改")
    @ApiOperationSupport(author = "sunweixin",order = 3)
    public Result<?> edit(@Valid @RequestBody BaseFieldUpdateForm baseFieldUpdateForm) {
        baseFieldService.edit(baseFieldUpdateForm);
        return Result.OK("修改成功");
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除", notes = "删除")
    @ApiOperationSupport(author = "sunwixin",order = 4)
    public Result<?> delete(@ApiParam(value = "id") @RequestParam(name = "id") Long id) {
        baseFieldService.deleteById(id);
        return Result.OK("删除成功");
    }

    /**
     * 获取字段类型
     */
    @GetMapping("getFieldType")
    @ApiOperation(value = "获取字段类型",notes = "获取字段类型")
    @ApiOperationSupport(author = "sunweixin",order = 5)
    public Result<?> getFieldType() {
        List<String> list = new ArrayList<>();
        FeildType[] values = FeildType.values();
        Arrays.stream(values).forEach(i -> list.add(i.getType()));
        return Result.OK(list);
    }

}
