package com.codingsaint.us.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingsaint.domain.User;
import com.codingsaint.security.UserService;

@RestController
public class UserController {
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 
	 * @param authorization
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public @ResponseBody User get(
			@RequestHeader(value = "Authorization") String authorization,
			@PathVariable("username") String username) {
		User userDetails = null;
		try {
			userDetails = userService.get(username);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}

	@RequestMapping("/users")
	public @ResponseBody List<User> getUsers() {
		List<User> users = null;
		try {
			users = userService.getAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(
			@RequestHeader(value = "Authorization") String authorization,
			@PathVariable("username") String username) {
		userService.delete(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addUser(
			@RequestHeader(value = "Authorization") String authorization,
			@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
	}
}
