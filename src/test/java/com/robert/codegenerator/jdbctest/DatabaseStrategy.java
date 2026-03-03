package com.robert.codegenerator.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sunweixin
 * @date 2024/7/27
 * @description
 */
public interface DatabaseStrategy {

    Connection getConnection(String url, String user, String password) throws SQLException;
}
