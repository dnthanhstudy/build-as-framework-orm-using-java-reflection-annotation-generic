package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

//    private static final ConnectionManager instance = new ConnectionManager();
//
//    private ConnectionManager(){
//
//    }
//
//    public static ConnectionManager getInstance(){
//        return instance;
//    }
//
//    public Connection getConnection() {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(SystemConstant.DB_URL, SystemConstant.USER,
//                    SystemConstant.PASS);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return con;
//    }
}
