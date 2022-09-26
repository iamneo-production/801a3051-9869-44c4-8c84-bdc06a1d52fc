/**
 * 
 */
package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "ADMIN")
public class AdminModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	private int id;
	private String email;
	private String password;
	private String phoneNumber;
	private String userRole;

	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminModel(String email, String password, String phoneNumber, String userRole) {
		super();
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "AdminModel [email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", userRole="
				+ userRole + "]";
	}

}
