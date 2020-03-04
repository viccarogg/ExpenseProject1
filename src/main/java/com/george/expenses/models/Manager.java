package com.george.expenses.models;

public class Manager extends User{
	public Manager(int id, String username, String password, String role, int manager_id) {
		super(id, username, password, role, manager_id);
		// TODO Auto-generated constructor stub
	}
	
	public Manager(int id, String username, String password, int manager_id) {
		super(id, username, password, "MANAGER", manager_id);
		// TODO Auto-generated constructor stub
	}
}
