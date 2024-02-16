package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.repository.jdbc.JdbcRepository;
import com.laptrinhjavaweb.repository.jdbc.annotation.TableJDBC;
import com.laptrinhjavaweb.repository.jdbc.mapper.ResultSetMapper;
import com.laptrinhjavaweb.utils.ConnectionManager;
import com.laptrinhjavaweb.utils.ConnectionUtils;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcRepository<T> implements JdbcRepository<T> {

    //private static final Connection con = ConnectionManager.getInstance().getConnection();

    @Override
    public List<T> findAll() {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        List<T> results = new ArrayList<>();
        ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
        String tableName = "";
        if (tClass.isAnnotationPresent(TableJDBC.class)) {
            TableJDBC table = tClass.getAnnotation(TableJDBC.class);
            tableName = table.name();
        }
        String sql = "SELECT * FROM " + tableName;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = ConnectionUtils.openConnection().createStatement();
            rs = stmt.executeQuery(sql);

            results =  resultSetMapper.mapRow(rs, tClass);
            return results != null ? results : null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
}
