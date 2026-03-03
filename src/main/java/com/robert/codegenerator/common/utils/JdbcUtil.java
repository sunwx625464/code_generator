package com.robert.codegenerator.common.utils;

import com.robert.codegenerator.common.strategy.DatabaseStrategy;
import com.robert.codegenerator.common.strategy.DatabaseStrategyRegistry;
import com.robert.codegenerator.module.domain.entity.DataOrigin;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sunweixin
 * @date 2024/7/25
 * @description jdbc工具类
 */
@Slf4j
public class JdbcUtil {

    /**
     * 连接超时时间6秒
     */
    private static final int CONNECTION_TIMEOUTS_SECONDS = 6;

    /**
     * 获取JDBC连接
     * @param dataOrigin 数据源对象
     * @return Connection连接对象
     * @author sunweixin
     */
    public static Connection getConnect(DataOrigin dataOrigin) throws SQLException {
        try {
            DatabaseStrategy strategy = DatabaseStrategyRegistry.getStrategy(dataOrigin.getType());
            // 加载驱动
            Class.forName(strategy.getDriverClass());
            String url = strategy.buildUrl(dataOrigin.getHostname(), dataOrigin.getPort(), dataOrigin.getDatabaseName());
            // 设置连接超时时间
            DriverManager.setLoginTimeout(CONNECTION_TIMEOUTS_SECONDS);
            // 拼接连接url
            return DriverManager.getConnection(url,dataOrigin.getUsername(),dataOrigin.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
