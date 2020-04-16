package com.ea.miushop.service.impl;

import org.springframework.stereotype.Service;

import com.ea.miushop.domain.Role;
import com.ea.miushop.domain.User;
import com.ea.miushop.repository.RoleRepository;
import com.ea.miushop.repository.UserRepository;
import com.ea.miushop.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
    private RoleRepository roleRepository;


	@Override
	public Role findByRole(String role) {
		
		return roleRepository.findByRole(role);

	}

}