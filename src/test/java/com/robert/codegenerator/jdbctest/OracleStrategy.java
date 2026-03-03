package com.robert.codegenerator.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sunweixin
 * @date 2024/7/27
 * @description
 */
public class OracleStrategy implements DatabaseStrategy {
    @Override
    public Connection getConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@" + url, user, password);
    }
}