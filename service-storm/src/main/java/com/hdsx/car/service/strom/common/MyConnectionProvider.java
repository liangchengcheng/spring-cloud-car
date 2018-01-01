package com.hdsx.car.service.strom.common;

import org.apache.storm.jdbc.common.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionProvider implements ConnectionProvider {

    private static String driver = "com.mysql.jdbc.driver";
    private static String url = "jdbc:mysql://192.168.2.1:3306/test";
    private static String user = "root";
    private static String password = "123456";

    static{

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            new ExceptionInInitializerError(e);
        }

    }

    @Override
    public void cleanup() {
    }

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void prepare() {

    }

}
