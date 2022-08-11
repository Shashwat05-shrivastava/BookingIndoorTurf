package com.booking.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Role;
import com.booking.entity.Turf;
import com.booking.entity.User;
import com.booking.entity.UserRole;
import com.booking.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		Role role = new Role();
		role.setId(501L);
		role.setRoleName("NORMAL");

		UserRole userRole1 = new UserRole();
		userRole1.setRole(role);
		userRole1.setUser(user);

		// encoding password
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> ur = new HashSet<>();
		ur.add(userRole1);
		return this.userService.createUser(user, ur);
	}

	// getting user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);

	}

	@DeleteMapping("/{id}")
	public void userId(@PathVariable("id") Long userId) {
		this.userService.deleteUser(userId);
	}

	// get All Users
	@GetMapping("/")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(this.userService.getUsers());
	}

	// Update Users
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}

}
