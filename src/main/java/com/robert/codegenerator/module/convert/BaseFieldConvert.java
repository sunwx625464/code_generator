package com.robert.codegenerator.module.convert;

import com.robert.codegenerator.module.domain.entity.BaseField;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldInsertForm;
import com.robert.codegenerator.module.domain.form.baseField.BaseFieldUpdateForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @author sunweixin
 * @date 2024/7/22
 * @description BaseField转换类
 */
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BaseFieldConvert {

    // 单例模式获取 (如果不使用 Spring 注入，可以用这个)
    BaseFieldConvert INSTANCE = Mappers.getMapper(BaseFieldConvert.class);

    /**
     * InsertForm -> Entity
     * @param form 数据源管理新增form
     * @return 数据源管理实体
     * @author sunweixin
     */
    BaseField toEntity(BaseFieldInsertForm form);

    /**
     * UpdateForm -> Entity
     * 特殊场景：更新时，通常先查出旧对象，然后将 Form 的非空字段覆盖到旧对象上
     * @param entity 标注目标对象 (被修改的对象)
     */
    void updateEntityFromForm(BaseFieldUpdateForm form, @MappingTarget BaseField entity);
}
