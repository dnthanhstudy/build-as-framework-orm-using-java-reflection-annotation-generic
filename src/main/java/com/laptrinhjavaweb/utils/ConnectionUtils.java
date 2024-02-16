package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static final Connection openConnection(){
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
