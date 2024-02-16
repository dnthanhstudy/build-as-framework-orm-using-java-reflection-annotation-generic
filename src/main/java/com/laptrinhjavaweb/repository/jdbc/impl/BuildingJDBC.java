package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;
import com.laptrinhjavaweb.repository.jdbc.entity.BuildingJDBCEntity;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingJDBC extends SimpleJdbcRepository<BuildingJDBCEntity> implements IBuildingJDBC {
}
