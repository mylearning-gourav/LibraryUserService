package com.userservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.dao.UserDao;
import com.userservice.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public ArrayList<Object> getAllUser() throws Exception {
		return userDao.getAllUser();
	}

	public void registerNewUser(User user) throws Exception {
		userDao.registerNewUser(user);
	}

	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	public void updateActiveStatus(int userId, boolean active) throws Exception {
		userDao.updateActiveStatus(userId, active);
	}

	public boolean getActiveStatus(int userId) throws Exception {
		return userDao.getActiveStatus(userId);
	}

	public boolean authenticateUser(String name, String password) throws Exception {
		return userDao.authenticateUser(name, password);
	}

}
