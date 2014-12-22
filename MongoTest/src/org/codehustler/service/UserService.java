package org.codehustler.service;

import org.codehustler.dao.UserModel;
import org.codehustler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	/**
	 * Retrieves User from database based on username
	 * 
	 * @param username
	 * @return User
	 */
	public UserModel findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	public void saveUser(UserModel user) {
		 userRepository.save(user);
	}
	
}
