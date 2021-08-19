package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDaoImpl;
import com.app.pojo.User;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	//dependency
	@Autowired
	private UserDaoImpl userDao;
	@Override
	public User validateUser(String email, String password) {
		return userDao.userAuthentic(email, password);
	}
	@Override
	public String userRegister(User user) {
		return userDao.regUser(user);
	}

}
