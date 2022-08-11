package com.booking;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.booking.entity.Role;
import com.booking.entity.User;
import com.booking.entity.UserRole;
import com.booking.services.UserService;
import java.util.logging.*;

@SpringBootApplication
public class BookingTurfApplication implements CommandLineRunner{
	Logger logger=Logger.getLogger(BookingTurfApplication.class.getSimpleName());
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BookingTurfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		User user=new User();
//		
//		user.setFirstName("shashwat");
//		user.setLastName("shrivastava");
//		user.setEmail("shashwat@gmail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setPhone("7549418232");
//		user.setUsername("shashwatsk");
//		
//		Role role=new Role();
//		role.setId(101L);
//		role.setRoleName("ADMIN");
//		
//		Set<UserRole>ur=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		ur.add(userRole);
//		
//		User user1=this.userService.createUser(user, ur);
//		logger.log(Level.INFO,user1.getUsername());
	}

}
