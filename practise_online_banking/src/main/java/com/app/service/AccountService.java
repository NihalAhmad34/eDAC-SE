package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AccountDaoImpl;
import com.app.pojo.Account;
import com.app.pojo.Type;
import com.app.pojo.User;

@Service
@Transactional
public class AccountService implements IAccountService {
	// dependency
	@Autowired
	private AccountDaoImpl accDao;

	@Override
	public List<Account> allAccount(int userId) {
		return accDao.fetchAllAccount(userId);
	}

	@Override
	public String withdrawAmount(int accId, double amount) {
		return accDao.withdrawAmount(accId, amount);
	}

	@Override
	public String depositeAmount(int accId, double amount) {
		if (amount >= 0) {
			return accDao.depositeAmount(accId, amount);
		} else {
			return "Amount is in positive";
		}
	}

	@Override
	public String closeAccount(int accId) {
		return accDao.closeAccount(accId);
	}

	@Override
	public List<Type> fetchAccType() {
		return accDao.allAccType();
	}

	@Override
	public String createAcc(User user, String type, double balance) {
		
		for(Account t : accDao.fetchAllAccount(user.getUser_id())) {
			if(t.getType().equals(Type.valueOf(type))) {
				throw new RuntimeException(type+" type, account already create");
			}
		}
		Account acc = new Account(Type.valueOf(type), balance);
		acc.setUsers(user);
		return accDao.createAcc(acc);
	}

}
