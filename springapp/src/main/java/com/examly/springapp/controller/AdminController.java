
package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.*;
import com.examly.springapp.repository.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private InstituteRepository instituteRepo;

	@Autowired
	private StudentRepository studentRepo;

	@PostMapping("/addCourse")
	public String addCourse(@RequestBody CourseModel courseBean) {
		try {
			if (courseBean.getCourseName() != null && courseBean.getCourseDuration() > 0
					&& courseBean.getCourseDescription() != null) {
				courseRepo.saveAndFlush(courseBean);
				return "Course Added Successfully";
			} else {
				return "Unable to add the course";
			}
		} catch (Exception e) {
			
			return "Exception occured while adding the course";
		}

	}

	@GetMapping("/viewCourse")
	public List<CourseModel> viewCourse() {

		return courseRepo.findAll();

	}

	@PutMapping("/editCourse/{courseId}")
	public String editCourse(@PathVariable("courseId") int courseId, @RequestBody CourseModel course) {
		try {
			Optional<CourseModel> presentCourse = courseRepo.findById(courseId);
			if (presentCourse.isPresent()) {
				CourseModel model = presentCourse.get();
				model.setCourseDescription(course.getCourseDescription());
				model.setCourseDuration(course.getCourseDuration());
				model.setCourseName(course.getCourseName());
				model.setCourseId(courseId);
				courseRepo.saveAndFlush(model);
				return "Course updated";
			} else {
				return "Unable to update the course";
			}
		} catch (Exception e) {
			
			return "Exception occured while updating the course";
		}

	}

	@DeleteMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable("courseId") int courseId) {
		try {
			courseRepo.deleteById(courseId);
			return "Course Deleted Successfully";
		} catch (Exception e) {
			
			return "Exception occured while deleting the course";
		}
	}

	@PostMapping("/addInstitute")
	public String addCourse(@RequestBody InstituteModel instituteBean) {
		try {
			if (instituteBean.getEmail() != null && instituteBean.getInstituteAddress() != null
					&& instituteBean.getInstituteDescription() != null && instituteBean.getMobile() != null
					&& instituteBean.getInstituteName() != null) {
				instituteRepo.saveAndFlush(instituteBean);
				return "Institute Added Successfully";
			} else {
				return "Unable to add the Institute";
			}
		} catch (Exception e) {
			
			return "Exception occured while adding the Institute";
		}

	}

	@GetMapping("/viewInstitute")
	public List<InstituteModel> viewInstitute() {

		return instituteRepo.findAll();

	}

	@PutMapping("/editInstitute/{instituteId}")
	public String editInstitute(@PathVariable("courseId") int courseId, @RequestBody InstituteModel institute) {
		try {
			Optional<InstituteModel> presentInstitute = instituteRepo.findById(courseId);
			if (presentInstitute.isPresent()) {
				InstituteModel model = presentInstitute.get();
				model.setEmail(institute.getEmail());
				model.setInstituteAddress(institute.getInstituteAddress());
				model.setInstituteDescription(institute.getInstituteDescription());
				model.setInstituteName(institute.getInstituteName());
				model.setMobile(institute.getMobile());
				model.setInstituteId(courseId);
				instituteRepo.saveAndFlush(model);
				return "Institute updated";
			} else {
				return "Unable to update the Institute";
			}
		} catch (Exception e) {
			
			return "Exception occured while updating the Institute";
		}

	}

	@DeleteMapping("/deleteInstitute/{instituteId}")
	public String deleteInstitute(@PathVariable("instituteId") int courseId) {
		try {
			instituteRepo.deleteById(courseId);
			return "Institute Deleted Successfully";
		} catch (Exception e) {
			
			return "Exception occured while deleting the Institute";
		}
	}

	@PostMapping("/addStudent")
	public String addStudent(@RequestBody StudentModel studenBean) {
		try {
			if (studenBean.getAge() > 5 && studenBean.getAddress() != null && studenBean.getStudentDob() != null
					&& studenBean.getMobile() != null && studenBean.getStudentName() != null) {
				studentRepo.saveAndFlush(studenBean);
				return "Student Added Successfully";
			} else {
				return "Unable to add the Student";
			}
		} catch (Exception e) {
			
			return "Exception occured while adding the Student";
		}

	}

	@GetMapping("/viewStudent")
	public List<StudentModel> viewStudent() {

		return studentRepo.findAll();

	}

	@PutMapping("/editStudent/{studentId}")
	public String editInstitute(@PathVariable("studentId") int courseId, @RequestBody StudentModel student) {
		try {
			Optional<StudentModel> presentInstitute = studentRepo.findById(courseId);
			if (presentInstitute.isPresent()) {
				StudentModel model = presentInstitute.get();
				model.setAddress(student.getAddress());
				model.setAge(student.getAge());
				model.setMobile(student.getMobile());
				model.setStudentDob(student.getStudentDob());
				model.setStudentName(student.getStudentName());
				model.setStudentId(courseId);
				studentRepo.saveAndFlush(model);
				return "Student updated";
			} else {
				return "Unable to update the Student";
			}
		} catch (Exception e) {
			
			return "Exception occured while updating the Student";
		}

	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int courseId) {
		try {
			studentRepo.deleteById(courseId);
			return "Student Deleted Successfully";
		} catch (Exception e) {
			
			return "Exception occured while deleting the Student";
		}
	}

}
