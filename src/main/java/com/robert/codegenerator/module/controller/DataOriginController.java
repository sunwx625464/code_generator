package com.robert.codegenerator.module.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.robert.codegenerator.common.domain.Result;
import com.robert.codegenerator.common.enums.DataBaseTypeEnum;
import com.robert.codegenerator.module.domain.entity.DataOrigin;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginInsertForm;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginUpdateForm;
import com.robert.codegenerator.module.service.DataOriginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description 数据源管理
 */

@Slf4j
@Api(tags = "数据源管理")
@RestController
@RequestMapping("/dataOrigin")
public class DataOriginController {

    @Resource
    private DataOriginService dataOriginService;

    /**
     * 列表查询
     */
    @GetMapping("/list")
    @ApiOperation(value = "列表查询", notes = "列表查询")
    @ApiOperationSupport(author = "sunweixin", order = 1)
    public Result<?> list(@ApiParam(value = "当前页") @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                          @ApiParam(value = "每页条数") @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                          @ApiParam(value = "连接名") @RequestParam(name = "connectName", required = false) String connectName,
                          @ApiParam(value = "数据库类型") @RequestParam(name = "type", required = false) Integer type) {
        IPage<DataOrigin> list = dataOriginService.getList(pageNo, pageSize, connectName, type);
        return Result.OK(list);
    }

    /**
     * 新建
     */
    @PostMapping("/add")
    @ApiOperation(value = "新建", notes = "新建")
    @ApiOperationSupport(author = "sunweixin", order = 2)
    public Result<?> add(@Valid @RequestBody DataOriginInsertForm dataOriginInsertForm) {
        dataOriginService.add(dataOriginInsertForm);
        return Result.OK("新增成功");

    }

    /**
     * 修改
     */
    @PutMapping("/edit")
    @ApiOperation(value = "修改", notes = "修改")
    @ApiOperationSupport(author = "sunweixin", order = 3)
    public Result<?> edit(@Valid @RequestBody DataOriginUpdateForm dataOriginUpdateForm) {
        dataOriginService.edit(dataOriginUpdateForm);
        return Result.OK("修改成功");
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除", notes = "删除")
    @ApiOperationSupport(author = "sunweixin", order = 4)
    public Result<?> delete(@ApiParam(value = "id") @RequestParam(name = "id") Long id) {
        dataOriginService.deleteById(id);
        return Result.OK("删除成功");
    }

    /**
     * 测试连接
     */
    @PostMapping("/testConnect")
    @ApiOperation(value = "测试连接", notes = "测试连接")
    @ApiOperationSupport(author = "sunweixin", order = 5)
    public Result<?> testConnect(@Valid @RequestBody DataOriginInsertForm dataOriginInsertForm) {
        dataOriginService.testConnect(dataOriginInsertForm);
        return Result.OK("连接成功!");
    }

    /**
     * 通过id测试连接
     */
    @PostMapping("/testConnectById")
    @ApiOperation(value = "通过id测试连接", notes = "通过id测试连接")
    @ApiOperationSupport(author = "sunweixin", order = 6)
    public Result<?> testConnectById(@ApiParam(value = "id") @RequestParam(value = "id") Long id) {
        dataOriginService.testConnectById(id);
        return Result.OK("连接成功!");
    }

    /**
     * 获取数据源
     */
    @GetMapping("/getDataOrigin")
    @ApiOperation(value = "获取数据源", notes = "获取数据源")
    @ApiOperationSupport(author = "sunweixin", order = 7)
    public Result<?> getDataOrigin() {
        DataBaseTypeEnum[] values = DataBaseTypeEnum.values();
        return Result.OK(values);
    }

}
