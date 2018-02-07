package context;

import com.senla.entities.User;

public class CurrentUserHolder {
	
	private User currentUser;

	public User getUser() {
		return currentUser;
	}

	public void setUser(User user) {
		currentUser = user;
	}

}
