package com.app.dao;

import com.app.pojo.User;

public interface IUserDao {
	//for login
	User userAuthentic(String email, String password);
	
	//Register User
	String regUser(User user);
}
