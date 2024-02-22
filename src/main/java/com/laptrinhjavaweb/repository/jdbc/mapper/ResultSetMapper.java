package com.laptrinhjavaweb.repository.jdbc.mapper;

import com.laptrinhjavaweb.repository.jdbc.annotation.ColumnJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.EntityJDBC;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper<T> {

    public List<T> mapRow(ResultSet rs, Class<T> tClass) {
        List<T> results = new ArrayList<>();
        try{
            if(tClass.isAnnotationPresent(EntityJDBC.class)){
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                int colCount = resultSetMetaData.getColumnCount();
                Field fields[] = tClass.getDeclaredFields();
                while(rs.next()){
                    T object = tClass.newInstance();

                    for(int i = 0; i < colCount; ++i)
                    {
                        String colName = resultSetMetaData.getColumnName(i + 1);
                        Object colValue = rs.getObject(i + 1);

                        for(Field file : fields) {
                            if(file.isAnnotationPresent(ColumnJDBC.class)) {
                                ColumnJDBC columnJDBC = file.getAnnotation(ColumnJDBC.class);
                                if(columnJDBC.name().equals(colName)) {
                                    BeanUtils.setProperty(object, colName, colValue);
                                    break;
                                }
                            }
                        }
                    }
                    results.add(object);
                }
            }
            return results;
        }catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
