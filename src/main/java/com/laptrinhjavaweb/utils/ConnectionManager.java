package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private ConnectionManager(){

    }

    private static class SingletonHelper{
        private static final ConnectionManager INSTANCE = new ConnectionManager();
    }

    public static ConnectionManager getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(SystemConstant.DB_URL, SystemConstant.USER,
                    SystemConstant.PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
