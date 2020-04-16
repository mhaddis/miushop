package com.ea.miushop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ea.miushop.domain.Category;
import com.ea.miushop.domain.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 
	User findByEmail(String email);
	User findByUserName(String userName);
}
