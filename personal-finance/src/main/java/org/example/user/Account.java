package org.example.user;

import java.security.NoSuchAlgorithmException;

import org.example.utils.PasswordUtil;

public class Account {
	private int id;
	private String username;
	private String hashPassword;

	public Account(int id, String username, String hashPassword) {
		this.id = id;
		this.username = username; 
		this.hashPassword = hashPassword;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return hashPassword;
	}

	public int getId() {return id;}

	public void setPassword(String password) {
		this.hashPassword = password;
	}

	public void setId(int id) {
		this.id = id;
	}
}

