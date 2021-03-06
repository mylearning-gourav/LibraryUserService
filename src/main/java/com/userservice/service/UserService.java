package com.userservice.service;

import java.util.ArrayList;

import com.userservice.entity.User;

public interface UserService {

	public ArrayList<Object> getUsers(User user) throws Exception;

	public void registerNewUser(User user) throws Exception;

	public void updateUser(User user) throws Exception;

	public void updateActiveStatus(int userId, boolean active) throws Exception;
	
	public void updateRole(int userId, int roleId) throws Exception;

//	public boolean getActiveStatus(int userId) throws Exception;

	public boolean authenticateUser(String email, String password) throws Exception;
	
	public boolean checkDuplicateEmail(String email) throws Exception;

}
