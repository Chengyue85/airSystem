package com.plus.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.plus.dao.OrderDao;
import com.plus.dao.PlaneDao;
import com.plus.dao.UserDao;
import com.plus.po.Order;
import com.plus.po.Plane;
import com.plus.po.User;
import com.plus.service.OrderService;
import com.plus.vo.OrderVo;

/**
 * 订单的service层
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PlaneDao planeDao;

	@Override//订票
	public String insertOrder(Order order) {

		Plane plane = planeDao.selectPlaneById(order.getPlaneId());
		User user = userDao.selectUserById(order.getUserid());
		try {
			if (plane.getNumber() <= 0) {
				return "当前此机票数量不够,您是否需要进入等待队列，等待机票？";
			}
			if (user.getMoney() < plane.getMoney()) {
				return "当前余额不足，请先充值";
			}

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = df.format(new Date());
			order.setTime(time);

			synchronized (this) {
				orderDao.insertOrder(order);
				userDao.updateUserDMoney(plane.getMoney(), order.getUserid());
				planeDao.updatePlaneDNumber(order.getPlaneId(), 1);
			}
			return "下单成功";
		} catch (Exception e) {
			// 事务回滚，手动添加
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			return null;
		}

	}

	@Override//选择用户订票的信息
	public List<OrderVo> selectOrderByUserId(int id) {
		try{
			List<OrderVo> lists =  orderDao.selectOrderByUserId(id);
			return lists;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	@Override
	public String back(int userid, int id) {
		Order order = orderDao.selectOrderById(id);
		Plane plane = planeDao.selectPlaneById(order.getPlaneId());
		
		synchronized (this) {
			try {
				userDao.updateUserIMoney(plane.getMoney(), userid);//用户加钱
				planeDao.updatePlaneINumber(plane.getId(), 1); //票数加+1
				orderDao.delectOrderById(id); 					//删除订单
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("出现异常");
				//return "退票失败，请稍后再试！";
			}
				
		}
		return "退票成功";
	}

	//用户进行改签
	@Transactional
	@Override
	public String change(int orderId, int planeId) {
		Order order = orderDao.selectOrderById(orderId);
		Plane oldPlane = planeDao.selectPlaneById(order.getPlaneId());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		order.setTime(time);
		order.setPlaneId(planeId);
		synchronized (this) {
			
			try{
			planeDao.updatePlaneINumber(oldPlane.getId(), 1);  //改签后 对应航班的剩余机票数进行增加或减少
			planeDao.updatePlaneDNumber(planeId, 1);
			orderDao.updateOrder(order);
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("改签出现异常");
			}
		}
		return "改签成功";
	}

	
	
	
}
