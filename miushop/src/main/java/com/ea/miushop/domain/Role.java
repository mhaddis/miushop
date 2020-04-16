package com.ea.miushop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Roles")
public class Role {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "Role_Id")	 
	 private Long role_id=null;
	 
	 private String role;

      
	public Long getRole_id() {
			return role_id;
		}

	public void setRole_id(Long role_id) {
			this.role_id = role_id;
		}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

		 
}
