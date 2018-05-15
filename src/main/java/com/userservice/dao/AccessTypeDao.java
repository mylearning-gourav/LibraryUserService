package com.userservice.dao;

import java.util.ArrayList;

import com.userservice.entity.AccessType;

/**
 * @author Gourav Singh
 * AccessType Dao Interface
 */
public interface AccessTypeDao {
	
	/**
	 * Get All Access Types
	 * @param
	 * @return List
	 * @throws Exception
	 */
	public ArrayList<Object> getAccessTypes() throws Exception;
	
	/**
	 * Get specific Access Types
	 * @param Integer[]
	 * @return List
	 * @throws Exception
	 */
	public ArrayList<Object> getAccessTypes(Integer... ids) throws Exception;
	
	/**
	 * Add Access Types
	 * @param AccessType
	 * @return boolean
	 * @throws Exception
	 */
	public void addAccessType(AccessType accessType) throws Exception;
	
	/**
	 * Update Access Types
	 * @param AccessType
	 * @return boolean
	 * @throws Exception
	 */
	public void updateAccessType(AccessType accessType) throws Exception;

}
