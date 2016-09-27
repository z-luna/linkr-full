package com.linkr.user.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linkr.user.domain.User;
import com.linkr.user.dto.UserDTO;
import com.linkr.user.service.UserService;


@Controller
@RequestMapping("/linkr")
public class UserController {
	
	private final Log logger = LogFactory.getLog(UserController.class); 
	
	@Autowired
	private UserService userService;

	
	@ResponseBody
	@RequestMapping("/createUser")
	public String createUser(String username, String email){
		logger.info(this.getClass().getName() + " # creatingUser...");
		String user = "";
		
		try {
			
			User newUser = userService.createUser(username, email);
			user = newUser.getUsername();
			logger.info("ID: " + newUser.getUserID() + " - UserName: " + newUser.getUsername());
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		return "Welcome User " + user;
	}
	
	
	
	
	/**
	 * Will correspond to @ResponseBody Object method param once integrated with FE
	 * 
	 * @param userDTO
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/create")
	public String create(@RequestBody UserDTO userDTO){
		logger.info(this.getClass().getName() + " # creatingUser...");
		
		try {
			
			User user = userService.create(userDTO);
		
			logger.info("ID: " + user.getUserID() + " - UserName: " + user.getUsername());
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		
		return "Welcome User " + userDTO.getUsername();
	}

}
