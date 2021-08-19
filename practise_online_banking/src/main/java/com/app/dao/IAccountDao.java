package com.app.dao;

import java.util.List;

import com.app.pojo.Account;
import com.app.pojo.Type;

public interface IAccountDao {
	// fetch all account of particular user\
	List<Account> fetchAllAccount(int userId);

	// Withdraw amount from user account
	String withdrawAmount(int accId, double amount);

	// Withdraw amount from user account
	String depositeAmount(int accId, double amount);

	// Withdraw amount from user account
	String closeAccount(int accId);
	
	//load all enum acc type
	List<Type> allAccType();
	
	//CReate Acc
		String createAcc(Account acc);
}
