package com.booking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.booking.entity.User;
import com.booking.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	Logger logger=Logger.getLogger(UserDetailsServiceImpl.class.getSimpleName());
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.userRepository.findByUsername(username);
		if(user==null) {
			logger.log(Level.INFO,"User not Found");
			throw new UsernameNotFoundException("No user Found");
		}
		return user;
	}
}


