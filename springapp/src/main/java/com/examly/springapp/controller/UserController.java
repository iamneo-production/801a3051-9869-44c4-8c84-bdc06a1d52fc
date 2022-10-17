package com.examly.springapp.controller;

import java.util.Date;
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
@RequestMapping("user")
public class UserController {

	@Autowired
	private AdmissionRepository admissionRepo;

	@PostMapping("addAdmission")
	public String addCourse(@RequestBody StudentModel studenBean, int courseId, int instituteId) {
		try {
			if (studenBean.getStudentName() != null && courseId != 0 && instituteId != 0) {

				AdmissionModel admission = new AdmissionModel();
				admission.setAdmissionRegisteredDate(new Date());
				admission.setStudentName(studenBean.getStudentName());
				admission.setCourseId(courseId);
				admission.setInstituteId(instituteId);
				admissionRepo.saveAndFlush(admission);
				return "Admission Enrolled";
			} else {
				return "Unable to add the admission";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception occured while adding the admission";
		}

	}

	@GetMapping("viewAdmission")
	public List<AdmissionModel> viewCourse() {

		return admissionRepo.findAll();

	}

	@PutMapping("editAdmission/{admissionId}")
	public String editCourse(@PathVariable("admissionId") int admissionId, @RequestBody CourseModel course) {
		try {
			Optional<AdmissionModel> presentCourse = admissionRepo.findById(admissionId);
			if (presentCourse.isPresent()) {
				AdmissionModel admission = presentCourse.get();
				admission.setAdmissionRegisteredDate(new Date());
				admission.setAdmissionId(admissionId);
				admissionRepo.saveAndFlush(admission);
				return "Admission updated";
			} else {
				return "Unable to update the Admission";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception occured while updating the admission";
		}

	}

	@DeleteMapping("deleteAdmission/{admissionId}")
	public String deleteCourse(@PathVariable("admissionId") int admissionId) {
		try {
			admissionRepo.deleteById(admissionId);
			return "Admission Deleted Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			return "Exception occured while deleting the Admission";
		}
	}

}
