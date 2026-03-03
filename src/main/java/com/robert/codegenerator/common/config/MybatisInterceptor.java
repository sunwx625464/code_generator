package com.robert.codegenerator.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.robert.codegenerator.module.domain.entity.BaseField;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author sunweixin
 * @date 2024/7/22$
 * @description mybatis-plus配置，自动填充创建时间和修改时间
 */
@Slf4j
@Component
public class MybatisInterceptor implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject,"deleted",Integer.class,0);
        this.strictInsertFill(metaObject,"status",Integer.class,0);
        Object originalObject = metaObject.getOriginalObject();

        // 判断是否是特定的类 (例如：BaseField)
        // 建议用 class 比较，或者用 class.getName() 比较，避免硬编码字符串
        if (originalObject instanceof BaseField) {

            // 针对特定字段填充
            // strictInsertFill 会自动检查该字段是否已有值，有值则不覆盖
            this.strictInsertFill(metaObject, "baseFlag", Integer.class,0);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }

}
