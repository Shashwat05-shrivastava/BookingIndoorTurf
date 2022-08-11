package com.booking.services;


import java.util.Set;


import org.springframework.stereotype.Service;


import com.booking.entity.User;
import com.booking.entity.UserRole;


@Service
public interface UserService {
	
	public User createUser(User user,Set<UserRole>userRoles) throws Exception;
	
	public User getUser(String username);
	
	public void deleteUser(Long id);
	
	public User updateUser(User user);
	
	public Set<User> getUsers();
	
}
