package com.plus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.dao.OrderDao;
import com.plus.dao.PlaneDao;
import com.plus.po.Order;
import com.plus.po.Plane;
import com.plus.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private PlaneDao planeDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public int insertPlane(Plane plane) {
		return planeDao.insertPlane(plane);
	}

	@Override
	public String  deletePlane(int id) {
		String result = "";
		try {
			List<Order> lists = orderDao.selectOrderByPlaneId(id);
			if(lists.size()>0){
				result = "当前有用户订了此航班的票，赞无法删除！";
			}else {
				planeDao.deletePlane(id);
				result = "删除成功";
			}
		} catch (Exception e) {
			result = "服务器繁忙，请稍后重试";
			e.printStackTrace();
		}
		return result;
	}
	
	

}
