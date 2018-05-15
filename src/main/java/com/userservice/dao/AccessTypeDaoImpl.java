package com.userservice.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.entity.AccessType;

/**
 * @author Gourav Singh
 * AccessType Dao Impl class
 * Implements AccessTypeDao
 */
@Transactional
@Repository("accessTypeDao")
public class AccessTypeDaoImpl implements AccessTypeDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Get All Access Types
	 * @param
	 * @return List
	 * @throws Exception
	 */
	@Override
	public ArrayList<Object> getAccessTypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get specific Access Types
	 * @param Integer[]
	 * @return List
	 * @throws Exception
	 */
	@Override
	public ArrayList<Object> getAccessTypes(Integer... ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Add Access Types
	 * @param AccessType
	 * @return 
	 * @throws Exception
	 */
	@Override
	public void addAccessType(AccessType accessType) throws Exception {
		entityManager.persist(accessType);
	}

	/**
	 * Update Access Types
	 * @param AccessType
	 * @return 
	 * @throws Exception
	 */
	@Override
	public void updateAccessType(AccessType accessType) throws Exception {
		entityManager.merge(accessType);
	}

}
