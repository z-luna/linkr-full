package com.linkr.user.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.linkr.user.domain.User;


@Repository
public class UserDAOImpl implements UserDAO {
	
	private final Log logger = LogFactory.getLog(UserDAOImpl.class); 
		
	@PersistenceContext
	private EntityManager em;

	
	/**
	 * Create user
	 * 
	 * @param user
	 * @return User
	 */
	public User createUser(User user) {
		logger.info(this.getClass().getName() + " #createUser");
		
		try {
			em.persist(user);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			
		}
		
		
		return user;
		
	}
	

}
