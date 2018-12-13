package com.userservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.entity.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;

	public ArrayList<Object> getUsers(User user) throws Exception {
		
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
	    CriteriaQuery cq = qb.createQuery();
	    Root<User> users = cq.from(User.class);
	    
	  //Constructing list of parameters
	    List<Predicate> predicates = new ArrayList<Predicate>();

	    //Adding predicates in case of parameter not being null
	    if (user.getUserId() != 0) {
	        predicates.add(
	                qb.equal(users.get("userId"), user.getUserId()));
	    }
	    if (user.getRoleId() != 0) {
	        predicates.add(
	                qb.equal(users.get("roleId"), user.getRoleId()));
	    }
	    if (user.getEmail() != null) {
	        predicates.add(
	                qb.equal(users.get("email"), user.getEmail()));
	    }
	    if (user.getName() != null) {
	        predicates.add(
	                qb.equal(users.get("name"), user.getName()));
	    }
	    
	    //query itself
	    cq.select(users)
	            .where(predicates.toArray(new Predicate[]{}));
	    //execute query and do something with result
	    return (ArrayList<Object>) entityManager.createQuery(cq).getResultList();
	    
		
//		entityManager.f
		/*String getUsersHsql = "SELECT id, name, email, password, active FROM User";
		return (ArrayList<Object>) entityManager.createQuery(getUsersHsql).getResultList();*/
	}

	public void registerNewUser(User user) throws Exception {
		entityManager.persist(user);
		entityManager.flush();
	}

	public void updateUser(User user) throws Exception {
		entityManager.merge(user);
	}

	public void updateActiveStatus(int userId, boolean active) throws Exception {
		User user = new User();
		user.setUserId(userId);
		user.setActive(active);
		entityManager.merge(user);
	}

	public boolean getActiveStatus(int userId) throws Exception {
		User user = entityManager.find(User.class, userId);
		return user.isActive();
	}

	public boolean authenticateUser(String name, String password) throws Exception {
		Query query = entityManager.createQuery("SELECT password FROM User WHERE name = ?");
		query.setParameter(1, name);
		String pass = (String) query.getSingleResult();
		if(pass != null && !pass.isEmpty() && pass.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

}
