package com.george.expenses.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.george.expenses.db.ReimbursementDAO;
import com.george.expenses.db.ReimbursementDB;
import com.george.expenses.models.Reimbursement;

@Path("/reimbursements")
public class RestReimbursement {
	ReimbursementDAO reimdb = new ReimbursementDB();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reimbursement> getReimbursements() {
		Collection<Reimbursement> reimbs = reimdb.getAllReimbursements();
		return reimbs;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reimbursement getReimbursement(@PathParam("id") int reimb_id) {
		Reimbursement reimb = reimdb.getReimbursement(reimb_id);
		return reimb;
	}
	
	@GET
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reimbursement> getReimbursementsByEmp(@PathParam("id") int emp_id) {
		Collection<Reimbursement> reimbs = reimdb.getReimbursementsByEmployee(emp_id);
		return reimbs;
	}
	
	@GET
	@Path("/employee/{id}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reimbursement> getReimbursementsByEmpAndStatus(
			@PathParam("id") int emp_id, @PathParam("status") String status) {
		status = status.toUpperCase();
		Collection<Reimbursement> reimbs = reimdb.getReimbursementsByEmployeeAndStatus(emp_id, status);
		return reimbs;
	}
	
	@GET
	@Path("/manager/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reimbursement> getReimbursementsByMan(@PathParam("id") int man_id) {
		Collection<Reimbursement> reimbs = reimdb.getReimbursementsByManager(man_id);
		return reimbs;
	}
	
	@GET
	@Path("/manager/{id}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Reimbursement> getReimbursementsByManAndStatus(
			@PathParam("id") int man_id, @PathParam("status") String status) {
		status = status.toUpperCase();
		Collection<Reimbursement> reimbs = reimdb.getReimbursementsByManagerAndStatus(man_id, status);
		return reimbs;
	}
	
	@POST
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void applyReimbursement(Reimbursement reimb) {
		reimdb.createReimbursement(reimb);
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void confirmReimbursement(Reimbursement reimb) {
		reimdb.reviewReimbursement(reimb.getReimbId(), reimb.getStatus());
	}
	
	
}
