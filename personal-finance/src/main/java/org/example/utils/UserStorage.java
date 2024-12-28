package org.example.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.example.user.Account;

public class UserStorage implements DataStorage<Map<String, Account>>{

	private final String filename; 
	
	public UserStorage() {
		this.filename = "users.csv";
	}

	@Override
	public void save(Map<String, Account> data) throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
			for (Account account : data.values()) {
                writer.write(String.format("%s,%s,%n", account.getUsername(), account.getPassword()));
			}
		}catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Map<String, Account> load() {
		Map<String, Account> accounts = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String line; 
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String username = parts[0];
					String password = parts[1];
					try {
					accounts.put(username, new Account(username, password));
					} catch (NoSuchAlgorithmException e) {
						
					}
				}
			}
		}
		return accounts;
	}
}
