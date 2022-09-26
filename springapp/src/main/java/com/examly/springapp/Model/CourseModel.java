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
@Table(name = "Course")
public class CourseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	private int courseId;
	private String courseName;
	private String courseDescription;
	private int courseDuration;

	public CourseModel(int courseId, String courseName, String courseDescription, int courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseDuration = courseDuration;
	}

	public CourseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "CourseModel [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", courseDuration=" + courseDuration + "]";
	}

}
