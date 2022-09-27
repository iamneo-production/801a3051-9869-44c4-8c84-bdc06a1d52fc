package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE")
	private int studentId;
	private String studentName;
	private String studentDob;
	private String address;
	private String mobile;
	private int age;

	public StudentModel() {
		super();
		
	}

	public StudentModel(int studentId, String studentName, String studentDob, String address, String mobile, int age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.address = address;
		this.mobile = mobile;
		this.age = age;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
				+ ", address=" + address + ", mobile=" + mobile + ", age=" + age + "]";
	}

}
