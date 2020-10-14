package com.trms.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	/**
	 * create a new user
	 * @param response
	 */
	default UserResponse createUser(User user) {
		UserResponse response = new UserResponse();
		user.setActive(false);
		user.setBlocked(false);
		
		if(findByUsername(user.getUsername()) == null) {// insert new user if unique
			save(user);
			response.setSuccess(true);
			response.setDetails("Created user");
		} else {
			response.setSuccess(true);
			response.setDetails("User already exists");
		}
		
		return response;
	}
	
	/**
	 * login to user account
	 * @param username
	 * @param password
	 * @return response
	 */
	default UserResponse login(String username, String password) {
		UserResponse response = new UserResponse();
		User user = findByUsernameAndPassword(username, password);
		
		if(user == null) {
			response.setSuccess(false);
			response.setDetails("Incorrect credentials");
		} else if(!user.isActive()) {
			response.setSuccess(false);
			response.setDetails("User is not activated");
		} else if (user.isBlocked()) {
			response.setSuccess(false);
			response.setDetails("User is blocked");
		} else {
			response.setSuccess(true);
			response.setUserId(user.getId());
			response.setUsername(user.getUsername());
			response.setDetails("Login successful");
		}
		
		return response;
	}
	
	/**
	 * find a user by username
	 * usernames are unique
	 * @param username
	 * @return user
	 */
	User findByUsername(String username);
	
	/**
	 * retrieve user by username and password
	 * @param username
	 * @param password
	 * @return user
	 */
	User findByUsernameAndPassword(String username, String password);

}
