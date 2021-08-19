package com.app.service;

import java.util.List;

import com.app.pojo.Account;
import com.app.pojo.Type;
import com.app.pojo.User;

public interface IAccountService {
	// Fetch all account
	List<Account> allAccount(int userId);

	// Withdraw amount
	String withdrawAmount(int accId, double amount);

	// Deposit amount
	String depositeAmount(int accId, double amount);

	// close Account
	String closeAccount(int accId);
	
	//get all acc type
	List<Type> fetchAccType();
	
	//create acc 
	String createAcc(User user, String type, double balance);
}
