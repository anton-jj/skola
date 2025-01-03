package org.example.utils;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.example.user.Account;

public class UserStorage implements DataStorage<Map<String, Account>> {

	private final String filename;

	public UserStorage() {
		this.filename = "users.csv";
	}

	@Override
	public void save(Map<String, Account> data) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (Account account : data.values()) {
				writer.write(String.format("%s,%s,%n", account.getUsername(), account.getPassword()));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	public Map<String, Account> load() {
		return Map.of();
	}

	/*public Map<String, Account> load() {
		Map<String, Account> accounts = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String username = parts[0];
					String password = parts[1];
					try {
						accounts.put(username, new Account(0, username, password));
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
				return accounts;
			}

		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		return accounts;
    }

	 */
}