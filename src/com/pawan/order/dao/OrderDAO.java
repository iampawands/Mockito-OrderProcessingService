package com.pawan.order.dao;

import java.sql.SQLException;

public interface OrderDAO {
	int create(Order order) throws SQLException;
	Order read(int id) throws SQLException;
	int delete(int id) throws SQLException;
	int update(Order order) throws SQLException;

}
