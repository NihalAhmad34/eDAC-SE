package com.app.pojo;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "pr_onbank_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Column(length = 50)
	private String name;
	@Column(length = 50, unique = true)
	private String email;
	@Column(length = 50)
	private String password;
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<Account> accounts = new ArrayList<>();

	public User() {
		System.out.println("in user constr");
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + "]";
	}

}
