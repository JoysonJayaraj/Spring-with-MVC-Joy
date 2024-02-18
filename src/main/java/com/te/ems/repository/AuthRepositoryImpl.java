package com.te.ems.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.entity.Employee;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL_PU");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String insertEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

		return employee.getEmployeeId();
	}

	@Override
	public boolean login(String empId, String password) {
//		Employee employee = entityManager.find(Employee.class, empId);
//		return employee.getPassword().equals(password);
		return entityManager.find(Employee.class, empId).getPassword().equals(password);
	}

	@Override
	public boolean updatePassword(String employeeId, String oldPassword, String newPassword) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (!employee.getPassword().equals(oldPassword)) {
			return false;
		}
		employee.setPassword(newPassword);
		entityManager.persist(employee);
		entityTransaction.commit();
		return true;
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee == null) {
			return false;
		}
		entityManager.remove(employee);
		entityTransaction.commit();
		return true;
	}

}
