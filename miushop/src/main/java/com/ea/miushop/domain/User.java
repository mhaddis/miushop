package com.ea.miushop.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="USER")
public class User {

	   @Id @GeneratedValue(strategy=GenerationType.AUTO)
	   @Column(name = "user_id")
	   private Long userid;
      
	   @Column(name = "username", nullable = false, unique = true)
	   private String userName;
		 
		@Column(name = "PASSWORD", nullable = false)
		private String password;

	 	String verifyPassword;
		private Boolean enabled;

	   @Size(min=4, max = 19, message= "{Size.name}")
	   @Column(name = "FIRSTNAME", nullable = false)
	    private String firstName;


	   @Size(min=4, max = 19, message= "{Size.name}")
	   @Column(name = "LASTNAME", nullable = false)
	   private String lastName;


	    @SuppressWarnings("deprecation")
		@NotEmpty
	    @Email(message = "{email}")
	    @Column(name = "EMAIL", nullable = false)
	    private String email;
	    
	    @Column(name = "active")
	    private Boolean active;
	    
//		@OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL) 
//		@JoinColumn(name="userId") 
//		private UserCredentials userCredentials;
		
		@ManyToMany(fetch =FetchType.EAGER)
		@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "Role_Id")})
		private Set<Role> roles;

		
		public Long getUserid() {
			return userid;
		}

		public void setUserid(Long userid) {
			this.userid = userid;
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

//		public UserCredentials getUserCredentials() {
//			return userCredentials;
//		}
//
//		public void setUserCredentials(UserCredentials userCredentials) {
//			this.userCredentials = userCredentials;
//		}

		
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

		public String getVerifyPassword() {
			return verifyPassword;
		}

		public void setVerifyPassword(String verifyPassword) {
			this.verifyPassword = verifyPassword;
		}

		public Boolean getEnabled() {
			return enabled;
		}

		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		
}