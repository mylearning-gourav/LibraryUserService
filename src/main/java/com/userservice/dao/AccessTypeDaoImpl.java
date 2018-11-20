package com.userservice.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
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
	
	/*final static Logger logger = Logger.getLogger(AccessTypeDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	*//**
	 * Get All Access Types
	 * @param
	 * @return List
	 * @throws Exception
	 *//*
	@Override
	public ArrayList<Object> getAllAccessTypes() throws Exception {
		logger.debug("Get All Access types Dao");
		String hsqlSelectQuery = "SELECT accessTypeId, accessType, description, active FROM AccessType";
		return (ArrayList<Object>) entityManager.createQuery(hsqlSelectQuery).getResultList();
	}

	*//**
	 * Get specific Access Types
	 * @param Integer[]
	 * @return List
	 * @throws Exception
	 *//*
	@Override
	public ArrayList<Object> getAccessTypes(Integer[] ids) throws Exception {
		logger.debug("Get All Access types with Ids Dao");
		StringBuilder hsqlSelectQuery = 
				new StringBuilder("SELECT accessTypeId, accessType, description, active FROM AccessType WHERE id ");
//		String hsqlSelectQuery = "SELECT accessTypeId, accessType, description, active FROM AccessType WHERE id ";
		if(ids.length == 1) {
			hsqlSelectQuery = hsqlSelectQuery.append("=" + ids[0]);
		}
		else {
			hsqlSelectQuery = hsqlSelectQuery.append("IN(");
			int count = 1;
			for(int id: ids) {
				if(count < ids.length) {
					hsqlSelectQuery = hsqlSelectQuery.append(id+", ");
				}
				else {
					hsqlSelectQuery = hsqlSelectQuery.append(id+")");
				}
				count++;
			}
		}
		logger.debug("SQL Statement Ids: " + hsqlSelectQuery);
		return (ArrayList<Object>) entityManager.createQuery(hsqlSelectQuery.toString()).getResultList();
	}
	
	*//**
	 * Get specific Access Types by type
	 * @param Integer[]
	 * @return List
	 * @throws Exception
	 *//*
	public ArrayList<Object> getAccessTypes(String[] types) throws Exception {
		logger.debug("Get All Access types with types Dao");
		StringBuilder hsqlSelectQuery = 
				new StringBuilder("SELECT accessTypeId, accessType, description, active FROM AccessType WHERE accessType ");
		if(types.length == 1) {
			hsqlSelectQuery = hsqlSelectQuery.append("= '" + types[0] + "'");
		}
		else {
			hsqlSelectQuery = hsqlSelectQuery.append("IN(");
			int count = 1;
			for(String type: types) {
				if(count < types.length) {
					hsqlSelectQuery = hsqlSelectQuery.append("'" + type +"', ");
				}
				else {
					hsqlSelectQuery = hsqlSelectQuery.append("'" + type +"')");
				}
				count++;
			}
		}
		logger.debug("SQL Statement types: " + hsqlSelectQuery);
		return (ArrayList<Object>) entityManager.createQuery(hsqlSelectQuery.toString()).getResultList();
	}
	
	*//**
	 * Get specific Access Types by active status
	 * @param Boolean
	 * @return List
	 * @throws Exception
	 *//*
	public ArrayList<Object> getAccessTypes(Boolean active) throws Exception {
		logger.debug("Get All Access types Dao with active");
		StringBuilder hsqlSelectQuery = 
				new StringBuilder("SELECT accessTypeId, accessType, description, active FROM AccessType WHERE active = " + active);
		return (ArrayList<Object>) entityManager.createQuery(hsqlSelectQuery.toString()).getResultList(); 
	}

	*//**
	 * Add Access Types
	 * @param AccessType
	 * @return 
	 * @throws Exception
	 *//*
	@Override
	public void addAccessType(AccessType accessType) throws Exception {
		logger.debug("Add Access Type Dao");
		entityManager.persist(accessType);
	}

	*//**
	 * Update Access Types
	 * @param AccessType
	 * @return 
	 * @throws Exception
	 *//*
	@Override
	public void updateAccessType(AccessType accessType) throws Exception {
		logger.debug("Update Access Type Dao");
		entityManager.merge(accessType);
	}*/

}
