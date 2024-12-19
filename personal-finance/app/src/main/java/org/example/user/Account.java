package org.example.user;

import java.security.NoSuchAlgorithmException;

import org.example.utils.PasswordUtil;

public class Account {
	private String username;
	private String hashPassword;

	public Account(String username, String password) throws NoSuchAlgorithmException {
		this.username = username; 
		this.hashPassword = PasswordUtil.hashPassword(password); 
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return hashPassword;
	}
}
