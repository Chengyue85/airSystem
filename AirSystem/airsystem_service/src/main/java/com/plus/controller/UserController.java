package com.plus.controller;

import com.alibaba.fastjson.JSONObject;
import com.plus.po.Result;
import com.plus.po.User;
import com.plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/validateUser")
	@ResponseBody
	public Result validateUser(@RequestBody User user,HttpServletRequest request){
		JSONObject json = new JSONObject();
		String result = userService.selectUserByPassword(user,request.getSession());
		json.put("message", result);
		Result re = new Result();
		if("登录成功".equals(result)){
//			json.put("status", 1);
			re.setCode(1);
			re.setMsg("请输入正确的用户名和密码");
		}else{
//			json.put("status", 0);
			re.setCode(0);
		}
		
		if(user.getAdmin() == 1){
//			json.put("admin", 1);
			re.setCode(2);
		}
		// 将获得的数据经过逻辑验证返回给界面微服务的控制层
		return re;
	}
}
