package com.george.expenses.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.george.expenses.db.EmployeeDAO;
import com.george.expenses.db.EmployeeDB;
import com.george.expenses.models.Employee;


@Path("/employees")
public class RestEmployee {
	EmployeeDAO empdb = new EmployeeDB();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Employee> getEmployees() {
		Collection<Employee> emps = empdb.getAllEmployees();
		return emps;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int emp_id) {
		Employee emp = empdb.getEmployee(emp_id);
		return emp;
	}

}


