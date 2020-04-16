package com.ea.miushop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Purchasers")
public class Purchaser {
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long purchaser_Id;

	    @Column(name = "FIRSTNAME", nullable = false)
	    private String firstName;
	    
	    @Column(name = "LASTNAME", nullable = false)
	    private String lastName;

	    @Column(name = "EMAIL", nullable = false)
	    private String email;

		public Long getPurchaser_Id() {
			return purchaser_Id;
		}

		public void setPurchaser_Id(Long purchaser_Id) {
			this.purchaser_Id = purchaser_Id;
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

		    
}
