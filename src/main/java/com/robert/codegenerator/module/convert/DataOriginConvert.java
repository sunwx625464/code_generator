package com.robert.codegenerator.module.convert;

import com.robert.codegenerator.module.domain.entity.DataOrigin;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginInsertForm;
import com.robert.codegenerator.module.domain.form.dataOrigin.DataOriginUpdateForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description DataOrigin转换类
 */
@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // componentModel = "spring": 表示生成的实现类是一个 Spring Bean，可以直接 @Autowired 注入
public interface DataOriginConvert {


    // 单例模式获取 (如果不使用 Spring 注入，可以用这个)
    DataOriginConvert INSTANCE = Mappers.getMapper(DataOriginConvert.class);

    /**
     * InsertForm -> Entity
     * @param form 数据源管理新增form
     * @return 数据源管理实体
     * @author sunweixin
     */
    DataOrigin toEntity(DataOriginInsertForm form);

    /**
     * UpdateForm -> Entity
     * 特殊场景：更新时，通常先查出旧对象，然后将 Form 的非空字段覆盖到旧对象上
     * @param entity 标注目标对象 (被修改的对象)
     */
    void updateEntityFromForm(DataOriginUpdateForm form, @MappingTarget DataOrigin entity);
}
