package com.te.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.dto.LoginDTO;
import com.te.ems.repository.AuthRepository;
import com.te.ems.repository.AuthRepositoryImpl;
import com.te.entity.Employee;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

//	private AuthRepository authRepository = new AuthRepositoryImpl(); instead of This watch down

//	@Autowired
//	private AuthRepository authRepository;

	private final AuthRepository authRepository;

	@Override
	public String register(String employeeId, String employeeAge, String employeeEmail, String password) {

		employeeId = authRepository.insertEmployee(Employee.builder().employeeId(employeeId)
				.employeeAge(Integer.parseInt(employeeAge)).employeeEmailId(employeeEmail).password(password).build());
		return employeeId;
	}

	@Override
	public boolean login(LoginDTO loginDTO) {
		return authRepository.login(loginDTO.getEmpId(), loginDTO.getPassword());
	}

	@Override
	public boolean resetPassword(String employeeId, String oldPassword, String newPassword) {
		return authRepository.updatePassword(employeeId, oldPassword, newPassword);
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		return authRepository.deleteEmployee(employeeId);
	}

}
