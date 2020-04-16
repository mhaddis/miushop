package com.ea.miushop.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ea.miushop.domain.Role;
import com.ea.miushop.domain.User;
import com.ea.miushop.domain.User_Role;
import com.ea.miushop.repository.RoleRepository;
import com.ea.miushop.repository.UserRepository;
import com.ea.miushop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	

	 private UserRepository userRepository;
	 private RoleRepository roleRepository;
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	@Override
	public User saveUser(User_Role userRole) {
		User user=new User();
		user.setPassword(bCryptPasswordEncoder.encode(userRole.getPassword()));
		user.setUserName(userRole.getUserName());
		user.setFirstName(userRole.getFirstName());
		user.setLastName(userRole.getLastName());
		user.setEmail(userRole.getEmail());
		user.setActive(true);
		user.setEnabled(true);
        Role role= roleRepository.findByRole(userRole.getRole_name().name());
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        return userRepository.save(user);

	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);

	}
  
	
	public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
	
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }


	@Override
	public void inActiveUser(Long id) {
       User user =  getUser(id);	
       if(user != null) {
    	   user.setActive(false);
    	   userRepository.save(user);
       }
	} 
     @Override
   	public void activeUser(Long id) {     
    	 User user =  getUser(id);	
         if(user != null) {
      	   user.setActive(true);
    	   userRepository.save(user);

         }
	}
}
