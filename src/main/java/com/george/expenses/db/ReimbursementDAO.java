package com.george.expenses.db;

import java.util.Collection;

import com.george.expenses.models.Reimbursement;

public interface ReimbursementDAO {
	// retrieving one or more reimbursements
	public Collection<Reimbursement> getAllReimbursements();
	public Reimbursement getReimbursement(int reimb_id);
	
	// retrieving reimbursements based on some condition
	// status = PENDING | APPROVED | DENIED
	public Collection<Reimbursement> getReimbursements(String status);
	public Collection<Reimbursement> getReimbursementsByEmployee(int emp_id);
	public Collection<Reimbursement> getReimbursementsByEmployeeAndStatus(int emp_id, String status);

	// to be called by an employee
	public void createReimbursement(Reimbursement reimb);
	// to be called by manager 
	public void reviewReimbursement(int reimb_id, String status);
}
