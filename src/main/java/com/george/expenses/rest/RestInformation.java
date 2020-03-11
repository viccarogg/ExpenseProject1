package com.george.expenses.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.george.expenses.db.EmployeeInfoDAO;
import com.george.expenses.db.EmployeeInfoDB;
import com.george.expenses.models.EmployeeInfo;

@Path("/info")
public class RestInformation {
	EmployeeInfoDAO infodb = new EmployeeInfoDB();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeInfo getInformation(@PathParam("id") int emp_id) {
		EmployeeInfo info = infodb.getMyInformation(emp_id);
		return info;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateInformation(@PathParam("id") int emp_id, EmployeeInfo info) {
		infodb.updateMyInformation(emp_id, info);
	}
}
