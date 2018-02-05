package com.senla.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.entities.User;
import com.senla.service.interfaces.IUserService;
import com.senla.storage.interfaces.IAbstractStorage;
import com.senla.storage.interfaces.IUserStorage;
import com.senla.util.AuthCodeEnum;

@Service
public class UserService extends AbstractService<User> implements IUserService {

	@Autowired
	private IUserStorage userStorage;

	@Override
	public IAbstractStorage<User> getStorage() {
		return userStorage;
	}

	@Override
	public AuthCodeEnum checkUser(String login, String password) {
		return executeAction(manager -> {
			try {
				User user = userStorage.getByLogin(manager, login);
				return user.getPassword().equals(password) ? AuthCodeEnum.SUCCESS_AUTH : AuthCodeEnum.WRONG_PASSWORD;
			} catch (EntityNotFoundException e) {
				return AuthCodeEnum.LOGIN_NOT_EXIST;
			}
		});
	}

	@Override
	public User getUserByLogin(String login) {
		return executeAction(manager -> {
			User user = userStorage.getByLogin(manager, login);
			return user;
		});
	}

}
