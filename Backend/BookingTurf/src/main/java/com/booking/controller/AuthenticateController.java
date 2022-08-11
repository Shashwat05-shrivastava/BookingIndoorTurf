package com.booking.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.config.JwtUtils;
import com.booking.entity.JwtRequest;
import com.booking.entity.JwtResponse;
import com.booking.entity.User;
import com.booking.exceptions.InvalidCredentialsException;
import com.booking.exceptions.InvalidUserException;
import com.booking.exceptions.UserDisabledException;
import com.booking.services.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	//generate Token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws InvalidUserException{
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
			throw new InvalidUserException("User not found");
		}
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username,String password) throws UserDisabledException,InvalidCredentialsException{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}catch(DisabledException e) {
			throw new UserDisabledException("USER DISABLED");
		}catch(BadCredentialsException e) {
			throw new InvalidCredentialsException("Inavlid Credentials"+e.getMessage());
		}
	}
	
	//for getting the details logged in user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
	}
}
