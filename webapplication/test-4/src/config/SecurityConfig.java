package config;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityConfig {
	// パスワードのハッシュ化とソルトの生成
	public static String hashPassword(String plainPassword) {
	    String salt = BCrypt.gensalt(); // ランダムなソルトを生成
	    String hashedPassword = BCrypt.hashpw(plainPassword, salt); // パスワードをハッシュ化
	    return hashedPassword;
	}

	// パスワードの検証
	public static boolean verifyPassword(String plainPassword, String hashedPassword) {
	    return BCrypt.checkpw(plainPassword, hashedPassword);
	}
}
