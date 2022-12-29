package com.plus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.plus.po.User;
import com.plus.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject login(@RequestBody User user,HttpServletRequest request){
		JSONObject json = new JSONObject();
		String result = userService.selectUserByPassword(user,request.getSession());
		json.put("message", result);
		
		if("登录成功".equals(result)){
			json.put("status", 1);
		}else{
			json.put("status", 0);
		}
		
		if(user.getAdmin() == 1){
			json.put("admin", 1);
		}
		return json;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public JSONObject register(@RequestBody User user){
		JSONObject json = new JSONObject();
		String result = userService.insertUser(user);
		json.put("message", result);
		return json;
	}
	
}
