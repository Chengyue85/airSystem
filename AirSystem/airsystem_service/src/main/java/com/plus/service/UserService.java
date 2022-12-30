package com.plus.service;

import com.plus.po.User;

import javax.servlet.http.HttpSession;

public interface UserService {

	public String selectUserByPassword(User user, HttpSession session);
	public String insertUser(User user);
}
