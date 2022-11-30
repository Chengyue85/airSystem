package com.plus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.plus.po.Order;
import com.plus.po.Plane;
import com.plus.po.WaitPlane;
import com.plus.service.OrderService;
import com.plus.service.PlaneService;
import com.plus.service.WaitPlaneService;
import com.plus.vo.OrderVo;

/**
 * 订单

 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private WaitPlaneService waitPlaneService;
	@Autowired
	private PlaneService planeService;

	@RequestMapping("/buyPlane")
	@ResponseBody
	public JSONObject buyPlane(@RequestBody Order order, HttpServletRequest request) { // 此时并非接受一个json数据
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		order.setUserid(userid);
		String result = orderService.insertOrder(order);
		if (result == null) {
			json.put("status", -1);
			json.put("message", "购票失败，请稍后重试，系统繁忙");
		} else if ("下单成功".equals(result)) {
			json.put("status", 1);
			json.put("message", result);
		} else if ("当前余额不足，请先充值".equals(result)) {
			json.put("status", 0);
			json.put("message", result);
		} else {
			json.put("status", 2);
			json.put("planeid", order.getPlaneId());
			json.put("message", result);
		}

		return json;

	}

	@PostMapping("/lookMyPlanes")
	@ResponseBody
	public JSONObject lookMyPlanes(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		// System.out.println(userid);
		List<OrderVo> lists = orderService.selectOrderByUserId(userid);
		if (lists == null) {
			json.put("status", -1);
			json.put("message", "当前服务器人数较多，获取相关信息失败，请重试!");
		} else if (lists.size() <= 0) {
			json.put("status", 0);
			json.put("message", "您当前还没有订购任何机票!");
		} else {
			json.put("status", 1);
			json.put("message", "查看成功");
			json.put("result", lists);
		}
		return json;
	}

	@GetMapping("/waitPlane")
	public String waitPlane(HttpServletRequest request, @RequestParam(value = "planeid") int planeid) {
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		WaitPlane waitPlane = new WaitPlane();
		waitPlane.setUserid(userid);
		waitPlane.setPlaneid(planeid);
		waitPlaneService.insertWaitPlane(waitPlane);
		return "redirect:/index.html";
	}

	@GetMapping("/back")
	@ResponseBody // 用户办理退票操作
	public JSONObject back(@RequestParam("id") int id, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		String message = "";
		try {
			message = orderService.back(userid, id);
			message = "退票成功";
			json.put("status", 1);
		} catch (Exception e) {
			message = "退票失败，请稍后再试！";
			json.put("status", 0);
		}
		json.put("message", message);
		// System.out.println(id);

		return json;
	}

	@GetMapping("/change")
	@ResponseBody // 用户获取可以改签的飞机
	public JSONObject change(@RequestParam("id") int id) {
		JSONObject json = new JSONObject();
		List<Plane> list = planeService.selectPlaneByName(id);
		if(list.size()>0&&list!=null){
			json.put("status", 1);
			json.put("list", list);
		}else{
			json.put("status", 0);
			json.put("message", "当前没有可改签的航班！");
		}
		
		return json;
	}
	
	@GetMapping("/changeOrder")
	@ResponseBody // 用户获取可以改签的飞机
	public JSONObject changeOrder(@RequestParam("id") int planeId,@RequestParam("orderId") int orderId) {
		JSONObject json = new JSONObject();
		
		try{
			String message = orderService.change(orderId, planeId);
			json.put("status", 1);
			json.put("message", message);
		}catch (Exception e) {
			json.put("status", -1);
			json.put("message", "改签失败，请稍后重试！");
		}
		
		
		
		return json;
	}
}
