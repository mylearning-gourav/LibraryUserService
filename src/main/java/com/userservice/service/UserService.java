package com.userservice.service;

import java.util.ArrayList;

import com.userservice.entity.User;

public interface UserService {

	public ArrayList<Object> getAllUser() throws Exception;

	public void registerNewUser(User user) throws Exception;

	public void updateUser(User user) throws Exception;

	public void updateActiveStatus(int userId, boolean active) throws Exception;

	public boolean getActiveStatus(int userId) throws Exception;

	public boolean authenticateUser(String name, String password) throws Exception;

}
