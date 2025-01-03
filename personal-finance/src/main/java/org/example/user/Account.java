package org.example.user;



public class Account {
	private int id;
	private String username;
	private String hashPassword;
	private double balance;

	public Account(int id, String username, String hashPassword, double balance) {
		this.id = id;
		this.username = username; 
		this.hashPassword = hashPassword;
		this.balance = 0.0;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return hashPassword;
	}

	public double getBalance() {
		return balance;
	}

	public int getId() {return id;}

	public void setId(int id) {
		this.id = id;
	}

	public void updateBalance(double balance) {
		this.balance = balance;
	}
}

