package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private EntityManager manager;

	@Override
	public User userAuthentic(String email, String password) {
		String jpql = "select u from User u where u.email = :email and u.password = :pass";
		return manager.createQuery(jpql, User.class).setParameter("email", email).setParameter("pass", password)
				.getSingleResult();
	}

	@Override
	public String regUser(User user) {
		manager.persist(user);
		return "User register Successfully at "+user.getUser_id();
	}
	

}
