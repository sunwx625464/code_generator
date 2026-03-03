package com.robert.codegenerator.module.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.robert.codegenerator.module.domain.entity.DataOrigin;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginInsertForm;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginUpdateForm;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description 数据源管理service
 */
public interface DataOriginService extends IService<DataOrigin> {

    /**
     * 分页列表查询
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @param connectName 连接名
     * @param type 数据库类型
     * @return 分页数据
     * @author sunweixin
     */
    IPage<DataOrigin> getList(Integer pageNo, Integer pageSize, String connectName, Integer type);

    /**
     * 新增
     * @param dataOriginInsertForm 数据源管理新增form
     * @author sunweixin
     */
    void add(DataOriginInsertForm dataOriginInsertForm);

    /**
     * 修改
     * @param dataOriginUpdateForm 数据源管理修改form
     * @author sunweixin
     */
    void edit(DataOriginUpdateForm dataOriginUpdateForm);

    /**
     * 测试连接
     * @param dataOriginInsertForm 数据源管理新增form
     * @author sunweixin
     */
    void testConnect(DataOriginInsertForm dataOriginInsertForm);

    /**
     * 通过id测试连接
     * @param id id
     * @author sunweixin
     */
    void testConnectById(Long id);

    /**
     * 通过id删除
     * @param id id
     * @author sunweixin
     */
    void deleteById(Long id);
}
