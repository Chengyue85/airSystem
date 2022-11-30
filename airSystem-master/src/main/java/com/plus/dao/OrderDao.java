package com.plus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.plus.po.Order;
import com.plus.vo.OrderVo;



/**
 * 订单的dao层
 */
@Repository
@Mapper
public interface OrderDao {

	public int insertOrder(Order order);
	public List<OrderVo> selectOrderByUserId(@Param("userid")int id);
	public List<Order> selectOrderByPlaneId(int planeId);
	public Order selectOrderById(int id);
	public int delectOrderById(int id);
	public int updateOrder(Order order);
}
