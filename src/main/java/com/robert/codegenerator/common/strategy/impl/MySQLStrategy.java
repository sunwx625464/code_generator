package com.robert.codegenerator.common.strategy.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.robert.codegenerator.common.strategy.DatabaseStrategy;

/**
 * @author sunweixin
 * @date 2026/3/2
 * @description mysql策略实现类
 */
public class MySQLStrategy extends DatabaseStrategy {


    public MySQLStrategy() {
        super("com.mysql.cj.jdbc.Driver", 3306);
    }

    @Override
    public String buildUrl(String hostname, Integer port, String databaseName) {
        int actualPort = getActualPort(port);
        StringBuilder url = new StringBuilder("jdbc:mysql://");
        url.append(hostname).append(":").append(actualPort).append("/");
        if (StringUtils.isNotBlank(databaseName)){
            url.append(databaseName);
        }
        // 追加默认参数
        url.append("?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8");
        return url.toString();
    }
}
