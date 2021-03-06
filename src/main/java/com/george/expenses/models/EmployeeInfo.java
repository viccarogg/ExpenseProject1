package com.george.expenses.models;

import java.sql.Date;

public class EmployeeInfo {
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String dob;
	private String address;
	private String phone;
	
	// these can't be edited/not in constructor
	private double salary;
	private String title;
	
	// this not in constructor but must be set by servlet
	private String modified;
	
	
	public String getModified() {
		return this.modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public EmployeeInfo(int empId, EmployeeInfo info) {
		this.empId = empId;
		this.firstName = info.getFirstName();
		this.lastName = info.getLastName();
		this.email = info.getEmail();
		this.dob = info.getDob();
		this.address = info.getAddress();
		this.phone = info.getPhone();
	}
	public EmployeeInfo(String firstName, String lastName, String email, String date, String address, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = date;
		this.address = address;
		this.phone = phone;
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	
	// maybe remove since employee won't be changing their salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	
	// same as salary - might not ever need
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(int emp_id) {
		// TODO Auto-generated method stub
		this.empId = emp_id;
	}
	
	public EmployeeInfo() {}
}
