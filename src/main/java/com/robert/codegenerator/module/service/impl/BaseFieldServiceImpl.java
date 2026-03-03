package com.robert.codegenerator.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.codegenerator.common.constant.CommonConstant;
import com.robert.codegenerator.common.exceptions.BusinessException;
import com.robert.codegenerator.module.convert.BaseFieldConvert;
import com.robert.codegenerator.module.domain.entity.BaseField;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldInsertForm;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldUpdateForm;
import com.robert.codegenerator.module.service.BaseFieldService;
import com.robert.codegenerator.module.mapper.BaseFieldMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.robert.codegenerator.common.constant.CommonConstant.SC_INTERNAL_SERVER_ERROR;


/**
 * @author sunweixin
 * @date 2024/7/22
 * @description 基础字段管理service实现
 */
@Service
public class BaseFieldServiceImpl extends ServiceImpl<BaseFieldMapper, BaseField> implements BaseFieldService{

    @Resource
    private BaseFieldMapper baseFieldMapper;


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
    @Override
    public IPage<BaseField> getList(Integer pageNo, Integer pageSize, Integer status, String fieldName, String fieldRemark) {
        LambdaQueryWrapper<BaseField> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(BaseField::getDeleted,0);
        if (status != null){
            lambdaQueryWrapper.eq(BaseField::getStatus, status);
        }
        if (StringUtils.isNotBlank(fieldName)) {
            lambdaQueryWrapper.eq(BaseField::getFieldName, fieldName);
        }
        if (StringUtils.isNotBlank(fieldRemark)) {
            lambdaQueryWrapper.like(BaseField::getFieldRemark, fieldRemark);
        }
        Page<BaseField> page = new Page<>(pageNo,pageSize);
        IPage<BaseField> baseFieldPage = baseFieldMapper.selectPage(page, lambdaQueryWrapper);
        return baseFieldPage;
    }


    /**
     * 新增基础字段
     * @param baseFieldInsertForm 新增请求form
     * @author sunweixin
     */
    @Override
    public void add(BaseFieldInsertForm baseFieldInsertForm) {
        BaseField baseField = BaseFieldConvert.INSTANCE.toEntity(baseFieldInsertForm);
        if (baseField == null){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"转换后对象为空，请检查输入参数");
        }
        int rows = baseFieldMapper.insert(baseField);
        if (rows <= 0){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"新增失败");
        }
    }


    /**
     * 修改基础字段
     * @param baseFieldUpdateForm 修改请求from
     * @author sunweixin
     */
    @Override
    public void edit(BaseFieldUpdateForm baseFieldUpdateForm) {
        BaseField baseFieldOld = baseFieldMapper.selectById(baseFieldUpdateForm.getId());
        if (baseFieldOld == null){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"更新的实体不存在");
        }
        BaseFieldConvert.INSTANCE.updateEntityFromForm(baseFieldUpdateForm,baseFieldOld);
        int rows = baseFieldMapper.updateById(baseFieldOld);
        if (rows <= 0){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"更新失败");
        }
    }

    /**
     * 通过id删除——保留系统内置字段
     * @param id id
     * @return 是否删除成功
     * @author sunweixin
     */
    @Override
    public void deleteById(Long id) {
        BaseField baseField = baseFieldMapper.selectById(id);
        if (baseField.getBaseFlag().equals(CommonConstant.BUILT_IN)){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"系统内置字段不能删除");
        }else {
            int rows = baseFieldMapper.deleteById(id);
            if (rows <= 0){
                throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"删除失败");
            }
        }
    }
}
