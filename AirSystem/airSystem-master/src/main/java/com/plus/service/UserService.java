package com.plus.service;

import javax.servlet.http.HttpSession;

import com.plus.po.User;

public interface UserService {

	public String selectUserByPassword(User user,HttpSession session);
	public String insertUser(User user);
}
