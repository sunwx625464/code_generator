package com.robert.codegenerator.common.strategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sunweixin
 * @date 2024/7/27
 * @description 数据源策略
 */
@Slf4j
@Getter
@RequiredArgsConstructor
public abstract class DatabaseStrategy {

    // 每个数据源特有的驱动类名
    private final String driverClass;

    // 每个数据源默认端口
    private final int defaultPort;

    /**
     * 模板方法，构建连接url
     * @param hostname 主机地址
     * @param port 端口
     * @param databaseName 数据库名
     * @return url地址
     * @author sunweixin
     */
    public abstract String buildUrl(String hostname,Integer port,String databaseName);

    /**
     * 获取最终使用的端口 (处理 null 值逻辑)
     * @param port 端口
     * @return url最终使用的端口
     * @author sunweixin
     */
    protected int getActualPort(Integer port) {
        return (port == null || port <= 0) ? this.defaultPort : port;
    }
}
