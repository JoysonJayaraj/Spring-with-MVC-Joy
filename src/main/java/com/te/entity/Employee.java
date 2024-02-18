package com.te.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
	@Id
	@Column(name = "employee_id")
	private String employeeId;
	@Column(name = "employee_age")
	private int employeeAge;
	@Column(name = "employee_email_id")
	private String employeeEmailId;

	private String password;
}
