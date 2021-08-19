package com.app.pojo;

import java.util.*;

import javax.persistence.*;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "pr_onbank_account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer acc_id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Type type;
	private double balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User users;

	public Account() {
		System.out.println("in acc const");
	}

	public Account(Integer acc_id, Type type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}
	public Account(Type type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	public Integer getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	public void withdraw(double amount) {
		if(this.balance-amount>=0) {
			this.balance=this.balance-amount;
		}else {
			throw new RuntimeException("no sufficiant balance");
		}
	}
	
	public void deposite(double amount) {
		this.balance=this.balance+amount;
	}

	@Override
	public String toString() {
		return "Account [acc_id=" + acc_id + ", type=" + type + ", balance=" + balance + "]";
	}

}
