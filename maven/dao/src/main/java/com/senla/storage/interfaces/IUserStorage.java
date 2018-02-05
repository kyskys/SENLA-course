package com.senla.storage.interfaces;

import javax.persistence.EntityManager;

import com.senla.entities.User;

public interface IUserStorage extends IAbstractStorage<User> {
	User getByLogin(EntityManager manager, String login);

	Long getUserIdByLogin(EntityManager manager, String login);
}
