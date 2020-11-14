package com.pawan.order.bo;

import com.pawan.order.bo.exception.BOException;
import com.pawan.order.dao.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id) throws BOException;
	boolean deleteOrder(int id) throws BOException;
}
