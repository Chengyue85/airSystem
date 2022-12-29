package com.plus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.plus.po.Plane;
import com.plus.service.AdminService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/insertPlane")
	public JSONObject insertPlane(@RequestBody Plane plane){
		JSONObject json = new JSONObject();
		int id = adminService.insertPlane(plane);
		
		if(id != 0){
			json.put("status", 1);
			json.put("message", "添加成功");
			json.put("id", id);
			System.out.println(id);
		}else{
			json.put("status", 0);
			json.put("message", "添加失败，请稍后再试！");
		}
		
		return json;
	}
	
	@GetMapping("deletePlane")
	public JSONObject deletePlane(@RequestParam(value = "planeId") int id){
		JSONObject json = new JSONObject();
		//System.out.println(id);
		String result = adminService.deletePlane(id);
		json.put("status", 1);
		json.put("message", result);
		return json;
	}
}
