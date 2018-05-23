package com.userservice.controller;

import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.bean.ResultBean;
import com.userservice.dao.AccessTypeDaoImpl;
import com.userservice.entity.AccessType;
import com.userservice.exception.BadRequestException;
import com.userservice.service.AccessTypeService;

/**
 * @author Gourav Singh
 * AccessType Controller Class
 */
@RestController
@RequestMapping(value="/accesstypeservices")
@Api(value="AccessTypeService", description="Access type Service for User")
public class AccessTypeController {
	
	final static Logger logger = Logger.getLogger(AccessTypeController.class);
	
	@Autowired
	private AccessTypeService accessTypeService;
	
	/**
	 * Add / Update Access Types
	 * @param  AccessType
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/updateaccesstype", method=RequestMethod.GET)
	public ResultBean updateAccessType(AccessType accessType) throws Exception {
		logger.debug("Add/Update Access Type Controller");
		accessTypeService.updateAccessType(accessType);
		ResultBean resultBean = new ResultBean();
		return resultBean;
	}
	
	/**
	 * Get All Access Types
	 * @param
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/getallaccesstypes", method=RequestMethod.GET)
	public ResultBean getAccessTypes(@RequestParam Optional<Integer[]> ids,
			@RequestParam Optional<String[]> types,
			@RequestParam Optional<Boolean> active) throws Exception {
		logger.debug("Get Access Type Controller");

		ResultBean resultBean = new ResultBean();
		HashMap<String, ArrayList<Object>> userResultMap = new HashMap<String, ArrayList<Object>>();
		
		if(ids.isPresent()) {
			Integer requestIds[] = ids.get();
			userResultMap.put("Access Types", accessTypeService.getAccessTypes(requestIds));
		}
		else if(types.isPresent()) {
			String requestTypes[] = types.get();
			userResultMap.put("Access Types", accessTypeService.getAccessTypes(requestTypes));
		}
		else if(active.isPresent()) {
			Boolean requestActive = active.get();
			userResultMap.put("Access Types", accessTypeService.getAccessTypes(requestActive));
		}
		else {
			userResultMap.put("Access Types", accessTypeService.getAllAccessTypes());
		}
		resultBean.setResult(userResultMap);
		return resultBean;
	}
	
	/**
	 * All Other Get Request
	 * @param
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/**", method=RequestMethod.GET)
	public void allOtherAccessTypeGetRequest() throws Exception {
		logger.debug("Bad Get Request Controller");
		throw new BadRequestException();
	}
	
	/**
	 * All Other Post Request
	 * @param
	 * @return ResultBean
	 * @throws Exception
	 */
	@RequestMapping(value="/**", method=RequestMethod.POST)
	public void allOtherAccessTypePostRequest() throws Exception {
		logger.debug("Bad Post Request Controller");
		throw new BadRequestException();
	}
}
