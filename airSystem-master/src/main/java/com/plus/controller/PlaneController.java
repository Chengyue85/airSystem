package com.plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.plus.po.Plane;
import com.plus.service.PlaneService;

/**

 */
@Controller
@RequestMapping("/plane")
public class PlaneController {
	
	@Autowired
	private PlaneService planeService;

	@RequestMapping("/index")
	@ResponseBody//获取所有机票信息
	public JSONObject index(){
		JSONObject json = new JSONObject();
		List<Plane> lists = planeService.selectAllPlane();
		if (lists == null) {
			json.put("status", -1);
			json.put("message", "获取航班信息出错！");
		}else if(lists.size()>0){
			json.put("status", 1);
			json.put("result", lists);
		}else{
			json.put("status", 0);
			json.put("message", "当前无航班信息，请稍后重试!");
		}
		return json;
	}
	
	
}
