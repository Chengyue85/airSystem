package com.plus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class IndexController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello word";
	}
	
	@RequestMapping("/")
	public String login(){
		return "login.html";
	}
	
	
}
