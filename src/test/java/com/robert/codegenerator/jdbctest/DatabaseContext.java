package com.robert.codegenerator.jdbctest;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sunweixin
 * @date 2024/7/27
 * @description
 */
public class DatabaseContext {

    private DatabaseStrategy strategy;

    public void setStrategy(DatabaseStrategy strategy) {
        this.strategy = strategy;
    }

    public Connection getConnection(String url, String user, String password) throws SQLException {
        if (strategy == null) {
            throw new IllegalStateException("Database strategy not set");
        }
        return strategy.getConnection(url, user, password);
    }
}
