package com.robert.codegenerator.module.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.robert.codegenerator.module.domain.entity.BaseField;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldInsertForm;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldUpdateForm;


/**
 * @author sunweixin
 * @date 2024/7/22
 * @description 基础字段管理service
 */
public interface BaseFieldService extends IService<BaseField> {

    /**
     * 分页列表查询
     *
     * @param pageNo  当前页
     * @param pageSize  煤业条数
     * @param status 状态
     * @param fieldName 字段名称
     * @param fieldRemark 字段备注
     * @return 数据集合
     * @author sunweixin
     */
    IPage<BaseField> getList(Integer pageNo, Integer pageSize,Integer status,String fieldName,String fieldRemark);

    /**
     * 新增基础字段
     * @param baseFieldInsertForm 新增请求form
     * @author sunweixin
     */
    void add(BaseFieldInsertForm baseFieldInsertForm);

    /**
     * 修改基础字段
     * @param baseFieldUpdateForm 修改请求from
     * @author sunweixin
     */
    void edit(BaseFieldUpdateForm baseFieldUpdateForm);

    /**
     * 通过id删除——保留系统内置字段
     * @param id id
     * @author sunweixin
     */
    void deleteById(Long id);
}
