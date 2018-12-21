package com.userservice.dao;

import java.util.ArrayList;

import com.userservice.entity.User;

public interface UserDao {
	public ArrayList<Object> getUsers(User user) throws Exception;

	public void registerNewUser(User user) throws Exception;

	public void updateUser(User user) throws Exception;

	public void updateActiveStatus(int userId, boolean active) throws Exception;

	public boolean getActiveStatus(int userId) throws Exception;

	public boolean authenticateUser(String name, String password) throws Exception;
	
    public boolean checkDuplicateEmail(String email) throws Exception;
	
}
