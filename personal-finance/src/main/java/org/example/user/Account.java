package org.example.user;

import java.security.NoSuchAlgorithmException;

import org.example.utils.PasswordUtil;

public class Account {
	private int id;
	private String username;
	private String hashPassword;

	public Account(int id, String username, String password) throws NoSuchAlgorithmException {
		this.id = id;
		this.username = username; 
		this.hashPassword = PasswordUtil.hashPassword(password); 
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return hashPassword;
	}

	public int getId() {return id;}

	public void setId(int id) {
		this.id = id;
	}
}

