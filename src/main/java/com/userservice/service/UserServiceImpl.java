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

	/**
	 * Get Users
	 * @param user
	 * @return ArrayList
	 * @throws Exception
	 */
	public ArrayList<Object> getUsers(User user) throws Exception {
		return userDao.getUsers(user);
	}

	/**
	 * Add New Users
	 * @param user
	 * @return 
	 * @throws Exception
	 */
	public void registerNewUser(User user) throws Exception {
		if(this.checkDuplicateEmail(user.getEmail())) {
			userDao.registerNewUser(user);
		}
		/*else {
			throw new
		}*/
		
	}

	/**
	 * Update Users
	 * @param user
	 * @return 
	 * @throws Exception
	 */
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	/**
	 * Update Active Status
	 * @param userId, active
	 * @return 
	 * @throws Exception
	 */
	public void updateActiveStatus(int userId, boolean active) throws Exception {
		userDao.updateActiveStatus(userId, active);
	}

	public boolean getActiveStatus(int userId) throws Exception {
		return userDao.getActiveStatus(userId);
	}

	/**
	 * Authenticate User
	 * @param email, password
	 * @return boolean
	 * @throws Exception
	 */
	public boolean authenticateUser(String email, String password) throws Exception {
		return userDao.authenticateUser(email, password);
	}

	/**
	 * Check Duplicate Email
	 * @param email
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkDuplicateEmail(String email) throws Exception {
		return userDao.checkDuplicateEmail(email);
	}

	/**
	 * Update Role
	 * @param userId, roleId
	 * @return 
	 * @throws Exception
	 */
	public void updateRole(int userId, int roleId) throws Exception {
		userDao.updateRole(userId, roleId);
		
	}

}
