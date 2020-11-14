package com.pawan.order.bo;

import java.sql.SQLException;

import com.pawan.order.bo.exception.BOException;
import com.pawan.order.dao.Order;
import com.pawan.order.dao.OrderDAO;

public class OrderBOImpl implements OrderBO {
	
	OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		int result;
		try {
			result = dao.create(order);
		} catch (SQLException e) {
			throw new BOException(e);
		}
		if(result==0) return false;
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		int result;
		try {
			Order order = dao.read(id);
			order.setStatus("cancelled");
			result = dao.update(order);
		} catch (SQLException e) {
			throw new BOException(e);
		}
		if(result==0) return false;
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		int result;
		try {
			result = dao.delete(id);
		} catch (SQLException e) {
			throw new BOException(e);
		}
		if(result==0) return false;
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
	
	

}
