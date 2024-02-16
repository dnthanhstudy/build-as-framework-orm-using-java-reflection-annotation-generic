package com.laptrinhjavaweb.repository.jdbc;

import java.util.List;

public interface JdbcRepository<T> {

    List<T> findAll();
}
