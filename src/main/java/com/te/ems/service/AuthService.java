package com.te.ems.service;

import com.te.ems.dto.LoginDTO;

public interface AuthService {

	String register(String employeeId, String employeeAge, String employeeEmail, String password);

	boolean login(LoginDTO loginDTO);

	boolean resetPassword(String employeeId, String oldPassword, String newPassword);

	boolean deleteEmployee(String employeeId);
}
