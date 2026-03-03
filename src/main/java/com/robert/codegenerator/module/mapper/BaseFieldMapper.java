package com.robert.codegenerator.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.robert.codegenerator.module.domain.entity.BaseField;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sunweixin
 * @date 2024/7/22$
 * @description 基础字段管理mapper
 */
@Mapper
public interface BaseFieldMapper extends BaseMapper<BaseField> {


}
