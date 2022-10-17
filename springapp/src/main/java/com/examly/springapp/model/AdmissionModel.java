package com.examly.springapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admission")
public class AdmissionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	private int admissionId;
	private int courseId;
	private int studentId;
	private String studentName;
	private Date admissionRegisteredDate;
	private int instituteId;
	private String instituteName;

	public AdmissionModel() {
		super();
	}

	public AdmissionModel(int admissionId, int courseId, int studentId, String studentName,
			Date admissionRegisteredDate, int instituteId, String instituteName) {
		super();
		this.admissionId = admissionId;
		this.courseId = courseId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.admissionRegisteredDate = admissionRegisteredDate;
		this.instituteId = instituteId;
		this.instituteName = instituteName;
	}

	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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

	public Date getAdmissionRegisteredDate() {
		return admissionRegisteredDate;
	}

	public void setAdmissionRegisteredDate(Date admissionRegisteredDate) {
		this.admissionRegisteredDate = admissionRegisteredDate;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

}
