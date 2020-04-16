package com.ea.miushop.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User_Role {
	
	
 	String userName;
	 
	String password;

    private String firstName;


    private String lastName;


    private String email;
    
	
	private Roles role_name;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Roles getRole_name() {
		return role_name;
	}

	public void setRole_name(Roles role_name) {
		this.role_name = role_name;
	}




}
