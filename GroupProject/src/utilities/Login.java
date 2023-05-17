package utilities;
import code.*;
public class Login {
	public static boolean LoginValidation (String username, String password) {
		for (Account i : VideoStore.getAccountList()) {
			if (username.equals(i.getUsername())) {
				if (password.equals(i.getPassword())) {
					return true;
				} else {
					System.out.println("Incorrect password!");
					return false;
				}
			}
		}
		System.out.println("Invalid username!");
		return false;
	}
}
