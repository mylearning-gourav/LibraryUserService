package com.userservice.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.entity.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;

	public ArrayList<Object> getAllUser() throws Exception {
		String getUsersHsql = "SELECT id, name, email, password, active FROM User";
		return (ArrayList<Object>) entityManager.createQuery(getUsersHsql).getResultList();
	}

	public void registerNewUser(User user) throws Exception {
		entityManager.persist(user);
	}

	public void updateUser(User user) throws Exception {
		entityManager.merge(user);
	}

	public void updateActiveStatus(int userId, boolean active) throws Exception {
		User user = new User();
		user.setUserId(userId);
		user.setActive(active);
		entityManager.merge(user);
	}

	public boolean getActiveStatus(int userId) throws Exception {
		User user = entityManager.find(User.class, userId);
		return user.isActive();
	}

	public boolean authenticateUser(String name, String password) throws Exception {
		Query query = entityManager.createQuery("SELECT password FROM User WHERE name = ?");
		query.setParameter(1, name);
		String pass = (String) query.getSingleResult();
		if(pass != null && !pass.isEmpty() && pass.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

}
