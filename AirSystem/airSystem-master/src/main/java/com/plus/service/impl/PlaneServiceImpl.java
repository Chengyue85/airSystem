package com.plus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.dao.OrderDao;
import com.plus.dao.PlaneDao;
import com.plus.po.Order;
import com.plus.po.Plane;
import com.plus.service.PlaneService;

/**航班类的服务层
 */
@Service
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	private PlaneDao planeDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Plane> selectAllPlane() {
		try{
			List<Plane> lists = planeDao.selectAllPlane();
			return lists;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override//根据航班名称选择飞机
	public List<Plane> selectPlaneByName(int orderId) {
		Order order = orderDao.selectOrderById(orderId);
		Plane plane = planeDao.selectPlaneById(order.getPlaneId());
		List<Plane> list = planeDao.selectPlaneByName(plane.getPlaneName());
		return list;
		
	}

}
