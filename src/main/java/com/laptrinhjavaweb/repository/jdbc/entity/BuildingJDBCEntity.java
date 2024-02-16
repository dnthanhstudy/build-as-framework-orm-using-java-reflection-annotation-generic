package com.laptrinhjavaweb.repository.jdbc.entity;

import com.laptrinhjavaweb.repository.jdbc.annotation.ColumnJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.EntityJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.TableJDBC;

@EntityJDBC
@TableJDBC(name = "building")
public class BuildingJDBCEntity {

    @ColumnJDBC(name = "name")
    private String name;

    @ColumnJDBC(name = "street")
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
