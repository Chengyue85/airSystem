package com.plus.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.dao.UserDao;
import com.plus.po.User;
import com.plus.service.UserService;
import com.plus.utils.StringUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userdao;
	
	private static StringUtils StringUtils = new StringUtils();
	

	@Override
	public String selectUserByPassword(User user,HttpSession session) {
		String result;
		if (StringUtils.isNull(user.getUsername()) || StringUtils.isNull(user.getPassword())) {
			return "用户名或者密码不得为空";
		}
		
		try {
			User u1 = userdao.selectUserByUserName(user.getUsername());
			if (u1 == null) {
				result = "不存在此用户";
//			}else if (!user.getPassword().equals(StringUtils.decryptBasedDes(u1.getPassword()))) {
			}else if (!user.getPassword().equals(u1.getPassword())) {
				result = "密码错误";
			}else if (user.getAdmin() == 1) {
				if(u1.getAdmin() == 0){
					result = "当前用户并不是管理员";
					return result;
				}else{
					result = "登录成功";
					session.setAttribute("userid", u1.getId());
				}
				
			}else {
				result = "登录成功";
				session.setAttribute("userid", u1.getId());
			}
			return result;
			
		} catch (Exception e) {
			result = "登录失败";
			e.printStackTrace();
			return result;
		}
	}

	@Override
	public String insertUser(User user) {
		String result;
		
		try{
			result = StringUtils.checkUser(user);
			if(!"数据合法".equals(result)){
				return result;
			}
			//对密码进行加密
//			user.setPassword(StringUtils.encryptBasedDes(user.getPassword()));
			user.setPassword(user.getPassword());
			synchronized (this) {
				User user1 = userdao.selectUserByUserName(user.getUsername());
				if(user1 !=null){
					result = "此用户名已被注册过";
				}else{
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time = df.format(new Date());
					user.setTime(time);
					userdao.insertUser(user);
					result = "恭喜您,亲爱的"+user.getUsername()+"用户，注册成功";
				}
				
			}
			
		}catch (Exception e) {
			result = "网络不好，注册失败，请重试!";
			e.printStackTrace();
		}
		return result;
	}
	

}
