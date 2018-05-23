package com.userservice.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.dao.AccessTypeDao;
import com.userservice.dao.AccessTypeDaoImpl;
import com.userservice.entity.AccessType;
import com.userservice.exception.DuplicateDataException;

@Service("accessTypeService")
public class AccessTypeServiceImpl implements AccessTypeService{
	
	final static Logger logger = Logger.getLogger(AccessTypeDaoImpl.class);
	
	@Autowired
	private AccessTypeDao accessTypeDao;

	/**
	 * Update Access Types
	 * @param AccessType
	 * @return boolean
	 * @throws Exception
	 */
	@Override
	public void updateAccessType(AccessType accessType) throws Exception {
		logger.debug("Update Access Type Service");
		if(accessType.getAccessTypeId() != 0) {
			accessTypeDao.updateAccessType(accessType);
		}
		else {
			String accessTypetring[] = {accessType.getAccessType()};
			if(accessTypeDao.getAccessTypes(accessTypetring).size() > 0) {
				throw new DuplicateDataException();
			}
			else {
				accessTypeDao.addAccessType(accessType);
			}
		}
	}

	/**
	 * Get All Access Types
	 * @param
	 * @return List
	 * @throws Exception
	 */
	@Override
	public ArrayList<Object> getAllAccessTypes() throws Exception {
		logger.debug("Get All Access types Service");
		return accessTypeDao.getAllAccessTypes();
	}

	/**
	 * Get specific Access Types by id
	 * @param Integer[]
	 * @return List
	 * @throws Exception
	 */
	@Override
	public ArrayList<Object> getAccessTypes(Integer[] ids) throws Exception {
		logger.debug("Get All Access types with Ids Service");
		return accessTypeDao.getAccessTypes(ids);
	}

	/**
	 * Get specific Access Types by type
	 * @param String[]
	 * @return List
	 * @throws Exception
	 */
	@Override
	public ArrayList<Object> getAccessTypes(String[] types) throws Exception {
		logger.debug("Get All Access types with types Service");
		return accessTypeDao.getAccessTypes(types);
	}

	/**
	 * Get specific Access Types by active status
	 * @param Boolean
	 * @return List
	 * @throws Exception
	 */
	@Override
	public ArrayList<Object> getAccessTypes(Boolean active) throws Exception {
		logger.debug("Update Access Type Service");
		return accessTypeDao.getAccessTypes(active);
	}

}
