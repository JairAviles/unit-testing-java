package com.mx.jairaviles.order.bo;

import java.sql.SQLException;

import com.mx.jairaviles.order.bo.exception.BOException;
import com.mx.jairaviles.order.dao.OrderDAO;
import com.mx.jairaviles.order.dto.Order;

public class OrderBOImpl implements OrderBO {
	
	private OrderDAO orderDao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = orderDao.create(order);
			
			if(result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = orderDao.read(id);
			order.setStatus("cancelled");
			int result = orderDao.update(order);
			
			if(result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = orderDao.delete(id);
			if(result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

}
