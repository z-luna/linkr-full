package com.linkr.user.service;

import com.linkr.user.domain.User;
import com.linkr.user.dto.UserDTO;


public interface UserService {

	User createUser(String username, String email);

	User create(UserDTO userDTO);

}
