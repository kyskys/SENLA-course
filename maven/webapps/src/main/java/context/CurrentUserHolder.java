package context;

import com.senla.entities.User;

public class CurrentUserHolder {
	private static User currentUser;

	public static User getUser() {
		return currentUser;
	}

	public static void setUser(User user) {
		currentUser = user;
	}
	
}
