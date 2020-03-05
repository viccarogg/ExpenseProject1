package com.george.expenses.db;

import java.util.Collection;

import com.george.expenses.models.Employee;
import com.george.expenses.models.Manager;

public interface EmployeeDAO {
	// these return false if there is no match in the database
	public boolean loginEmployee(String username, String password);
	public boolean loginManager(String username, String password);
	
	public Employee getEmployee(int emp_id);
	public Manager getManager(int emp_id);
	public Collection<Employee> getAllEmployees();
	
	// this will be called with a manager id (STRETCH)
	public Collection<Employee> getMyEmployees(int emp_id);
	
}
