package com.ea.miushop.service;

import com.ea.miushop.domain.Role;
import com.ea.miushop.domain.User;
import com.ea.miushop.domain.User_Role;

import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public User saveUser(User_Role userRole);
	public User findByEmail(String email);
	public User findUserByUserName(String userName);
	public List<User> getAllUsers();
	public User getUser(Long id);
	public void inActiveUser(Long id);
	public void activeUser(Long id);


}
