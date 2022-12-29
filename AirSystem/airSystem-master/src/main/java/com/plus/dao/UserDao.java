package com.plus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.plus.po.User;

@Repository("userDao")
@Mapper
public interface UserDao {

	public User selectUserByUserName(String username);
	public  User selectUserByPassword(User user);
	public  User selectUserById(int id);
	public int insertUser(User user);//返回的是操作的条数
	public int updateUserDMoney(@Param("money")int money,@Param("userid")int userid);
	public int updateUserIMoney(@Param("money")int money,@Param("userid")int userid);
	
}
