package com.app.service;

import com.app.pojo.User;

public interface IUserService {
	//user validate and login
	User validateUser(String email, String password);
	
	//user register
	String userRegister(User user);
}
