package com.linkr.user.service;


import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkr.user.dao.UserDAO;
import com.linkr.user.domain.User;
import com.linkr.user.dto.UserDTO;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private final Log logger = LogFactory.getLog(UserServiceImpl.class); 
	
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Service implementation using [x] params
	 * 
	 * @param username
	 * @return User
	 */
	public User createUser(String username, String email) {
		logger.info(this.getClass().getName() + " #createUser");
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		
		return userDAO.createUser(user);
		
	}

	/**
	 * Service implementation using DTO
	 * 
	 * @param userDTO
	 * @return User
	 */
	public User create(UserDTO userDTO) {
		logger.info(this.getClass().getName() + " #createUser");
		
		User user = new User();
		
		try {
			user.setUsername(userDTO.getUsername());
			user.setEmail(userDTO.getEmail());
			userDAO.createUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
		
	}

}
