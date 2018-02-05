package com.senla.service.interfaces;

import com.senla.entities.User;
import com.senla.util.AuthCodeEnum;

public interface IUserService extends IAbstractService<User> {
	AuthCodeEnum checkUser(String login, String password);
	
	User getUserByLogin(String login);
	
	Long getUserIdByLogin(String login);
}
