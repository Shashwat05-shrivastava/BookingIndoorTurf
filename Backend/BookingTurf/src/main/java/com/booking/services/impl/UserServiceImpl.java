package com.booking.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.User;
import com.booking.entity.UserRole;
import com.booking.exceptions.UserAlreadyExistException;
import com.booking.repository.RoleRepository;
import com.booking.repository.UserRepository;
import com.booking.services.UserService;
import java.util.logging.*;
@Service
public class UserServiceImpl implements UserService{
	
	Logger logger=Logger.getLogger(UserServiceImpl.class.getSimpleName());
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws UserAlreadyExistException {
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			logger.log(Level.INFO,"User already Exist");
			throw new UserAlreadyExistException("User Already Exist");
		}else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}
	
	@Override
	public User getUser(String username) {

		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long id) {

		this.userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return this.userRepository.save(user);
		
	}

	@Override
	public Set<User> getUsers() {
		return new LinkedHashSet<>(this.userRepository.findAll());
	}
	
	
	
}
