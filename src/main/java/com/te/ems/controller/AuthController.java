package com.te.ems.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.ems.dto.LoginDTO;
import com.te.ems.repository.AuthRepositoryImpl;
import com.te.ems.service.AuthService;
import com.te.ems.service.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 2
@RequestMapping(path = "/app/auth")
@Controller
public class AuthController {

//	private AuthService authService = new AuthServiceImpl(new AuthRepositoryImpl()); // not a good idea

//	@Autowired
//	private AuthService authService; // good way

	private final AuthService authService; // better way 1

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String register() {
		return "registration";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, ModelMap modelMap) {
		System.out.println("We reached here ! register(HttpServletRequest request");
		String employeeId = request.getParameter("empId");
		String employeeAge = request.getParameter("empAge");
		String employeeEmail = request.getParameter("empEmail");
		String password = request.getParameter("password");
//		System.out.println(employeeId);
//		System.out.println(employeeAge);
//		System.out.println(employeeEmail);
//		System.out.println(password);

		// TODO: Implement Registration
		employeeId = authService.register(employeeId, employeeAge, employeeEmail, password);

		modelMap.addAttribute("message", "Registration Successful for EmployeeId : " + employeeId);
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
		System.out.println("We are in ! login(@ModelAttribute Object obj)");
		System.out.println(loginDTO.getEmpId());
		System.out.println(loginDTO.getPassword());

		// String employeeId = authService.login(loginDTO);

//		if (!loginDTO.getPassword().equals("Password")) {
//			model.addAttribute("message", "Login Unsuccessful");
//			return "login";
//		}

		// TODO: Implement Login

		boolean isLoggedIn = authService.login(loginDTO);
		if (!isLoggedIn) {
			model.addAttribute("message", "Login Unsuccessful");
			return "login";
		}
		return "welcome";

	}

	@RequestMapping(path = "/resetPassword", method = RequestMethod.GET)
	public String resetPassword() {
		return "resetPassword";
	}

	@RequestMapping(path = "/resetPassword", method = RequestMethod.POST)
	public String resetPassword(@RequestParam(name = "empId") String employeeId,
			@RequestParam(name = "oldPassword") String oldPassword,
			@RequestParam(name = "newPassword") String newPassword,
			@RequestParam(name = "retypePassword") String retypePassword, Model model) {
//		System.out.println(employeeId);
//		System.out.println(oldPassword);
//		System.out.println(newPassword);
//		System.out.println(retypePassword);

		/*
		 * if (!newPassword.equals(retypePassword)) { 
		 * 			model.addAttribute("message","Reset Un-SuccessFul");
		 * 		    return "resetPassword"; 
		 * }
		 * model.addAttribute("message", "Reset Successful");
		 * return "login";
		 */

		// coded later for checking with DB
		if (!newPassword.equals(retypePassword)) {
			model.addAttribute("message", "New Password and retyped new password is not same");
			return "resetPassword";
		}

		boolean couldResetPassword = authService.resetPassword(employeeId, oldPassword, newPassword);
		if (couldResetPassword) {
			model.addAttribute("message", "Reset Password Successful!");
			return "login";
		}
		model.addAttribute("message", "Reset Password UnSuccessful!");
		return "resetPassword";
	}

	@RequestMapping(path = "/delete", method = RequestMethod.GET)
	public String deleteEmployee() {
		return "deleteEmployee";
	}

	@RequestMapping(path = "/delete",  method = RequestMethod.POST)
	public String deleteEmployee(@RequestParam(name = "empId") String employeeId, Model model) {

		boolean b = authService.deleteEmployee(employeeId);
		if (b) {
			model.addAttribute("message", "Employee Deleted");
			return "login";
		}
		model.addAttribute("message", "Employee Not Available");
		return "login";
	}

}
