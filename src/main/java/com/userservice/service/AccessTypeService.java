package com.userservice.service;

import java.util.ArrayList;

import com.userservice.entity.AccessType;

/**
 * @author Gourav Singh
 * AccessType Service Interface
 */
public interface AccessTypeService {
	
	/**
	 * Get All Access Types
	 * @param
	 * @return List
	 * @throws Exception
	 */
	public ArrayList<Object> getAllAccessTypes() throws Exception;
	
	/**
	 * Get specific Access Types by id
	 * @param Integer[]
	 * @return List
	 * @throws Exception
	 */
	public ArrayList<Object> getAccessTypes(Integer[] ids) throws Exception;
	
	/**
	 * Get specific Access Types by type
	 * @param String[]
	 * @return List
	 * @throws Exception
	 */
	public ArrayList<Object> getAccessTypes(String[] types) throws Exception;
	
	/**
	 * Get specific Access Types by active status
	 * @param Boolean
	 * @return List
	 * @throws Exception
	 */
	public ArrayList<Object> getAccessTypes(Boolean active) throws Exception;
	
	/**
	 * Update Access Types
	 * @param AccessType
	 * @return boolean
	 * @throws Exception
	 */
	public void updateAccessType(AccessType accessType) throws Exception;
	

}
