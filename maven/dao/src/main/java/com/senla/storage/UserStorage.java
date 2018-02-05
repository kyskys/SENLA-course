package com.senla.storage;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.senla.entities.User;
import com.senla.storage.interfaces.IUserStorage;

import connector.DBConnector;

@Service
public class UserStorage extends AbstractStorage<User> implements IUserStorage {

	@Override
	public Class<User> getGenericClass() {
		return User.class;
	}

	@Override
	protected void joinLazyFields(Root<?> root) {
	}

	@Override
	public User getByLogin(EntityManager manager, String login) {
		CriteriaBuilder builder = DBConnector.getManager().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("login"), login));
		TypedQuery<User> result = DBConnector.getManager().createQuery(query);
		User user = result.getSingleResult();
		return user;
	}

	
}
