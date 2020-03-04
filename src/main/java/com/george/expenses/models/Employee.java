package com.george.expenses.models;

public class Employee extends User {

	public Employee(int id, String username, String password, String role, int manager_id) {
		super(id, username, password, role, manager_id);
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String username, String password, int manager_id) {
		super(id, username, password, "EMPLOYEE", manager_id);
		// TODO Auto-generated constructor stub
	}
	

}
