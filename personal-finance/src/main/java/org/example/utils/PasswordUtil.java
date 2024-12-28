package org.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256"); 
		byte[] bytes = md.digest(password.getBytes()); 

		StringBuilder hexString = new StringBuilder();
		for(byte b : bytes) {
			hexString.append(String.format("%02x", b ));
		}
		return hexString.toString();
	}

	public static boolean checkPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
		return hashedPassword.equals(hashPassword(password));
	}
}
