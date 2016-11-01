package com.mx.jairaviles.order.bo;

import com.mx.jairaviles.order.bo.exception.BOException;
import com.mx.jairaviles.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;
	
}
