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
@Table(name = "USER")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	private int id;
	private String email;
	private String password;
	private String userName;
	private String phoneNumber;
	private String userRole;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "UserModel [email=" + email + ", password=" + password + ", userName=" + userName + ", phoneNumber="
				+ phoneNumber + ", userRole=" + userRole + "]";
	}

	public UserModel(String email, String password, String userName, String phoneNumber, String userRole) {
		super();
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.userRole = userRole;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
