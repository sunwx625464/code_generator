package com.robert.codegenerator.common.strategy;

import com.robert.codegenerator.common.enums.DataBaseTypeEnum;
import com.robert.codegenerator.common.strategy.impl.MySQLStrategy;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author sunweixin
 * @date 2026/3/2
 * @description 策略模式注册工厂
 */
public class DatabaseStrategyRegistry {

    private static final Map<DataBaseTypeEnum, DatabaseStrategy> STRATEGY_MAP = new EnumMap<>(DataBaseTypeEnum.class);

    // 初始化注册策略实现类
    static {
        STRATEGY_MAP.put(DataBaseTypeEnum.MYSQL,new MySQLStrategy());
    }

    /**
     * 通过数据库类型获取策略实现类
     * @param type 数据库类型
     * @return 对应策略实现类
     * @author sunweixin
     */
    public static DatabaseStrategy getStrategy(DataBaseTypeEnum type) {
        DatabaseStrategy strategy = STRATEGY_MAP.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("不支持的数据库类型: " + type);
        }
        return strategy;
    }


    /**
     * 通过字符串名称获取策略实现类
     * @param typeName 数据库字符串名称
     * @return 对应的策略实现类
     * @author sunweixin
     */
    public static DatabaseStrategy getStrategy(String typeName) {
        try {
            DataBaseTypeEnum type = DataBaseTypeEnum.valueOf(typeName.toUpperCase());
            return getStrategy(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("不支持的数据库类型名称: " + typeName, e);
        }
    }
}
