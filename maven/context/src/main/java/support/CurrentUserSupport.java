package support;

import com.senla.entities.User;

import holder.CurrentUserHolder;
import provider.ApplicationContextProvider;

public interface CurrentUserSupport {
	public default User getCurrentUser() {
		return ApplicationContextProvider.getApplicationContext().getBean(CurrentUserHolder.class).getUser();
	}
}
