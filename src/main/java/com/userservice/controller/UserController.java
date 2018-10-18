package com.userservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.bean.ResultBean;
import com.userservice.entity.User;
import com.userservice.service.UserService;

@RestController
@RequestMapping(value="/userservices")
@Api(value="UserService", description="User Service for Library")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getallusers", method=RequestMethod.GET)
	@ApiOperation(value = "View a list of users", response = ResultBean.class)
	public ResultBean getAllUser() throws Exception {
		ResultBean resultBean = new ResultBean();
		HashMap<String, ArrayList<Object>> userResultMap = new HashMap<String, ArrayList<Object>>();
		userResultMap.put("Result", userService.getAllUser());
		resultBean.setResult(userResultMap);
		return resultBean;
	}
	
	@RequestMapping(value="/registeruser", method=RequestMethod.GET)
	@ApiOperation(value="Register new user", response=ResultBean.class)
	public ResultBean registerNewUser(User user) throws Exception {
		userService.registerNewUser(user);
		ResultBean resultBean = new ResultBean();
		return resultBean;
	}
	
	@RequestMapping(value="/updateuser", method=RequestMethod.GET)
	@ApiOperation(value="Update user", response=ResultBean.class)
	public ResultBean updateUser(User user) throws Exception{
		userService.updateUser(user);
		ResultBean resultBean = new ResultBean();
		return resultBean;
	}
	
	@RequestMapping(value="/updateactivestatus", method=RequestMethod.GET)
	@ApiOperation(value="Update user status", response=ResultBean.class)
	public ResultBean updateActiveStatus(int userId, boolean active) throws Exception {
		userService.updateActiveStatus(userId, active);
		ResultBean resultBean = new ResultBean();
		return resultBean;
	}
	
	@RequestMapping(value="/getactivestatus", method=RequestMethod.GET)
	@ApiOperation(value="Get user status", response=ResultBean.class)
	public ResultBean getActiveStatus(int userId) throws Exception {
		Boolean status = userService.getActiveStatus(userId);
		if(status) {
			ResultBean resultBean = new ResultBean(2001, "User is Active");
			return resultBean;
		}
		else {
			ResultBean resultBean = new ResultBean(3001, "User is Inactive");
			return resultBean;
		}
	}
	
	@RequestMapping(value="/authenticateuser", method=RequestMethod.GET)
	@ApiOperation(value="Authenticate user", response=ResultBean.class)
	public ResultBean authenticateUser(String name, String password) throws Exception {
		Boolean status = userService.authenticateUser(name, password);
		if(status) {
			ResultBean resultBean = new ResultBean(2002, "User is Authenticate");
			return resultBean;
		}
		else {
			ResultBean resultBean = new ResultBean(3002, "User Authentication Failed");
			return resultBean;
		}
	}
}