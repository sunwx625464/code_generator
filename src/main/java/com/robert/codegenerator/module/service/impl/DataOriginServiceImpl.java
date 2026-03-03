package com.robert.codegenerator.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.robert.codegenerator.common.exceptions.BusinessException;
import com.robert.codegenerator.common.utils.JdbcUtil;
import com.robert.codegenerator.module.convert.DataOriginConvert;
import com.robert.codegenerator.module.domain.entity.DataOrigin;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginInsertForm;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginUpdateForm;
import com.robert.codegenerator.module.mapper.DataOriginMapper;
import com.robert.codegenerator.module.service.DataOriginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

import static com.robert.codegenerator.common.constant.CommonConstant.SC_INTERNAL_SERVER_ERROR;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description 数据源管理service实现
 */
@Slf4j
@Service
public class DataOriginServiceImpl extends ServiceImpl<DataOriginMapper, DataOrigin> implements DataOriginService{

    @Resource
    private DataOriginMapper dataOriginMapper;


    /**
     * 分页列表查询
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @param connectName 连接名
     * @param type 数据库类型
     * @return 分页数据
     * @author sunweixin
     */
    @Override
    public IPage<DataOrigin> getList(Integer pageNo, Integer pageSize, String connectName, Integer type) {
        LambdaQueryWrapper<DataOrigin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(connectName)) {
            lambdaQueryWrapper.eq(DataOrigin::getHostname, connectName);
        }
        if (type != null) {
            lambdaQueryWrapper.eq(DataOrigin::getType, type);
        }
        Page<DataOrigin> page = new Page<>(pageNo,pageSize);
        IPage<DataOrigin> pageList = dataOriginMapper.selectPage(page,lambdaQueryWrapper);
        return pageList;
    }

    /**
     * 新增
     * @param dataOriginInsertForm 数据源管理新增form
     * @author sunweixin
     */
    @Override
    public void add(DataOriginInsertForm dataOriginInsertForm) {
        DataOrigin dataOrigin = DataOriginConvert.INSTANCE.toEntity(dataOriginInsertForm);
        if (dataOrigin == null){
            throw new BusinessException(HttpStatus.BAD_REQUEST.value(),"转换后对象为空，请检查输入参数");
        }
        int rows = dataOriginMapper.insert(dataOrigin);
        if (rows <= 0){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR, "新增失败");
        }
    }

    /**
     * 修改
     * @param dataOriginUpdateForm 数据源管理修改form
     * @author sunweixin
     */
    @Override
    public void edit(DataOriginUpdateForm dataOriginUpdateForm) {
        DataOrigin dataOriginOld = dataOriginMapper.selectById(dataOriginUpdateForm.getId());
        if (dataOriginOld == null){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"更新的实体不存在");
        }
        DataOriginConvert.INSTANCE.updateEntityFromForm(dataOriginUpdateForm,dataOriginOld);
        int rows = dataOriginMapper.updateById(dataOriginOld);
        if (rows <= 0){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR, "修改失败");
        }
    }

    /**
     * 测试连接
     * @param dataOriginInsertForm 数据源管理新增form
     * @author sunweixin
     */
    @Override
    public void testConnect(DataOriginInsertForm dataOriginInsertForm) {
        DataOrigin dataOrigin = DataOriginConvert.INSTANCE.toEntity(dataOriginInsertForm);
        if (dataOrigin == null){
            throw new BusinessException(HttpStatus.BAD_REQUEST.value(),"转换后对象为空，请检查输入参数");
        }
        try {
            JdbcUtil.getConnect(dataOrigin);
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
            throw new BusinessException(5000,"连接失败");
        }
    }

    /**
     * 通过id测试连接
     * @param id id
     * @author sunweixin
     */
    @Override
    public void testConnectById(Long id) {
        DataOrigin dataOrigin = dataOriginMapper.selectById(id);
        try {
            JdbcUtil.getConnect(dataOrigin);
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
            throw new BusinessException(5000,"连接失败");
        }
    }

    /**
     * 通过id删除
     * @param id id
     * @author sunweixin
     */
    @Override
    public void deleteById(Long id) {
        int rows = dataOriginMapper.deleteById(id);
        if (rows <= 0){
            throw new BusinessException(SC_INTERNAL_SERVER_ERROR,"删除失败");
        }
    }
}
