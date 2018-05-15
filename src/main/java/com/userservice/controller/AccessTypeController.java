package com.userservice.controller;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.bean.ResultBean;
import com.userservice.entity.AccessType;
import com.userservice.exception.BadRequestException;

/**
 * @author Gourav Singh
 * AccessType Controller Class
 */
@RestController
@RequestMapping(value="/accesstypeservices")
@Api(value="AccessTypeService", description="Access type Service for User")
public class AccessTypeController {
	
	/**
	 * Get All Access Types
	 * @param
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/getallaccesstypes", method=RequestMethod.GET)
	public ResultBean getAccessTypes(Integer... id) throws Exception {
		ResultBean resultBean = new ResultBean();
		return resultBean;
	}
	
	/**
	 * Add / Update Access Types
	 * @param  AccessType
	 * @return ResultBean
	 * @throws Exception
	 */
	public ResultBean updateAccessType(AccessType accessType) {
		ResultBean resultBean = new ResultBean();
		return resultBean;
	}
	
	/**
	 * All Other Get Request
	 * @param
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/**", method=RequestMethod.GET)
	public void allOtherGetRequest() throws Exception {
		throw new BadRequestException();
	}
	
	/**
	 * All Other Post Request
	 * @param
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/**", method=RequestMethod.POST)
	public void allOtherPostRequest() throws Exception {
		throw new BadRequestException();
	}
}
