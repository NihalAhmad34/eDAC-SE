package com.app.dao;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.controller.AcccountController;
import com.app.pojo.Account;
import com.app.pojo.Type;

@Repository

public class AccountDaoImpl implements IAccountDao {
	@Autowired
	private EntityManager manager;

	@Override
	public List<Account> fetchAllAccount(int userId) {
		String jpql = "select a from Account a where user_id=:uid";
		return manager.createQuery(jpql, Account.class).setParameter("uid", userId).getResultList();
	}

	@Override
	public String withdrawAmount(int accId, double amount) {
		System.out.println("in withdrw dao process");
		Account acc = manager.find(Account.class, accId);
		System.out.println("account details - " + acc);
		acc.withdraw(amount);
		System.out.println("account details - " + acc);
		try {
			manager.persist(acc);
			System.out.println("account details - " + acc);
			return "Successfully Update! ";
		} catch (RuntimeException e) {
			throw new RuntimeException(e);

		}

	}

	@Override
	public String depositeAmount(int accId, double amount) {
		System.out.println("in deposite dao process");
		Account acc = manager.find(Account.class, accId);
		System.out.println("account details - " + acc);
		acc.deposite(amount);
		System.out.println("account details - " + acc);
		try {
			manager.persist(acc);
			System.out.println("account details - " + acc);
			return "Successfully Update! ";
		} catch (RuntimeException e) {
			throw new RuntimeException(e);

		}
	}

	@Override
	public String closeAccount(int accId) {
		System.out.println("in deposite dao process");
		Account acc = manager.find(Account.class, accId);
		System.out.println("account details - " + acc);
		try {
			manager.remove(acc);
			System.out.println("account details - " + acc);
			return "Successfully Close Account! ";
		} catch (RuntimeException e) {
			throw new RuntimeException(e);

		}
	}

	@Override
	public List<Type> allAccType() {
		System.out.println("in dao - acc type list");
		List<Type> list = new ArrayList<Type>(Arrays.asList(Type.values()));
		return list;
	}

	@Override
	public String createAcc(Account acc) {
		manager.persist(acc);
		return "Created acc - "+acc.getAcc_id();
	}
}
