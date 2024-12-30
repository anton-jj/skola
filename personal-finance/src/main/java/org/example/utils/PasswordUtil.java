package org.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

	public static String hashPassword(String password) {
		int workFactor = 12;
		return BCrypt.hashpw(password, BCrypt.gensalt(workFactor));
	}


	public static boolean checkPassword(String password, String hashedPassword)  {
		if (hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
                throw new IllegalArgumentException("Invalid hash version");
        }
		return BCrypt.checkpw(password, hashedPassword);
	}
}
