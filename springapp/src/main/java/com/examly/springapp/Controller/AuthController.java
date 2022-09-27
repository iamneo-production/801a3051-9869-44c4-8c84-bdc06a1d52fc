
package com.examly.springapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Model.*;
import com.examly.springapp.Repository.*;

@RestController
public class AuthController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AdminRepository adminRepo;

	@GetMapping(value = "user/login")
	public boolean isUserPresent(@RequestBody LoginModel loginBean) {
		if (loginBean.getEmail() != null && loginBean.getPassword() != null) {
			UserModel user = userRepo.logginInUser(loginBean.getEmail(), loginBean.getPassword());
			return user.getEmail().equalsIgnoreCase(loginBean.getEmail())
					&& user.getPassword().equals(loginBean.getPassword()) ? true : false;
		} else {
			return false;
		}

	}

	@GetMapping(value = "admin/login")
	public boolean isAdminPresent(@RequestBody LoginModel loginBean) {
		if (loginBean.getEmail() != null && loginBean.getPassword() != null) {
			return loginBean.getEmail().equalsIgnoreCase("admin") && loginBean.getPassword().equals("admin") ? true
					: false;
		} else {
			return false;
		}

	}

	@PostMapping(value = "/user/signup")
	public String saveUser(@RequestBody UserModel userBean) {
		try {

			if (userBean.getUserName() != null && userBean.getEmail() != null && userBean.getPassword() != null
					&& userBean.getPhoneNumber() != null) {
				userBean.setUserRole("USER");
				userRepo.saveAndFlush(userBean);
				return "User Added";
			} else {
				return "Unable to Add User";
			}

		} catch (Exception e) {
			return "Exception Occured while adding User";
		}
	}

	@PostMapping(value = "admin/signup")
	public String saveAdmin(@RequestBody AdminModel bean) {
		try {

			if (bean.getEmail() != null && bean.getPassword() != null && bean.getPhoneNumber() != null) {
				bean.setUserRole("ADMIN");
				adminRepo.saveAndFlush(bean);
				return "Admin Added";
			} else {
				return "Unable to Add Admin";
			}

		} catch (Exception e) {
			return "Exception Occured while adding Admin";
		}
	}

}
