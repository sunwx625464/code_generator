package com.robert.codegenerator.jdbctest;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sunweixin
 * @date 2024/7/27
 * @description
 */
public class Main {
    public static void main(String[] args) {
        DatabaseContext context = new DatabaseContext();

        // 使用MySQL策略
        context.setStrategy(new MySQLStrategy());
        try {
            Connection connection = context.getConnection("localhost:3306/mydatabase", "user", "password");
            System.out.println("MySQL connection established: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 使用PostgreSQL策略
        context.setStrategy(new PostgreSQLStrategy());
        try {
            Connection connection = context.getConnection("localhost:5432/mydatabase", "user", "password");
            System.out.println("PostgreSQL connection established: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 使用Oracle策略
        context.setStrategy(new OracleStrategy());
        try {
            Connection connection = context.getConnection("localhost:1521/mydatabase", "user", "password");
            System.out.println("Oracle connection established: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

