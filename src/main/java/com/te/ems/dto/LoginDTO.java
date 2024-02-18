package com.te.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LoginDTO {
	// name="empId" of login.jsp and data member empId should be same else we get null
	private String empId; 
	// name="password" of login.jsp and data member password should be same else we get null
	private String password;

}
