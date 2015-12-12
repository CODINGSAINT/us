package com.codingsaint.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codingsaint.domain.User;
import com.codingsaint.repository.UserRepository;
/**
 * 
 * @author The Saint
 *
 */
@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional
	public List<User> getAll() {
		List<User> users=userRepository.findAll();
		return users;
	}

	@Transactional
	public void delete(String username) {
		userRepository.delete(username);
	}

	@Transactional
	public User get(final String username) {
		String lowercaseusername=username.toLowerCase();
		User user=userRepository.findByUsernameCaseInsensitive(lowercaseusername);
		return user;
	}

}
