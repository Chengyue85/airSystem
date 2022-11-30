package com.plus.service;

import java.util.List;

import com.plus.po.Order;
import com.plus.vo.OrderVo;

public interface OrderService {

	public String insertOrder(Order order);
	public List<OrderVo> selectOrderByUserId(int id);
	public String back(int userid,int id);
	public String change(int orderId,int planeId);
}
