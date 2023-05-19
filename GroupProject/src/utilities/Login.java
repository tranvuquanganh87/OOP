package utilities;
import code.*;
public class Login {
	public static Account LoginValidation (String username, String password) {
		for (Account i : VideoStore.getAccountList()) {
			if (username.equals(i.getUsername())) {
				if (password.equals(i.getPassword())) {
					return i;
				} else {
					System.out.println("Incorrect password!");
					return null;
				}
			}
		}
		System.out.println("Invalid username!");
		return null;
	}
}
