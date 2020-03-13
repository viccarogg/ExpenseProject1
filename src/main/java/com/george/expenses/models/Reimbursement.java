package com.george.expenses.models;

import java.sql.Blob;

public class Reimbursement {
	private int reimbId;
	private String description;
	private String status;
	private double amount;
	private int ownerId;
	private Blob receiptImage;	// STRETCH
	
	// manually set when calling create, data from session
	private String creator;
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Reimbursement(int reimbId, String description, String status, double amount, int ownerId) {
		super();
		this.reimbId = reimbId;
		this.description = description;
		this.status = status;
		this.amount = amount;
		this.ownerId = ownerId;
	}
	
	// STRETCH
	public Reimbursement(int reimbId, String description, String status, double amount, int ownerId,
			Blob receiptImage) {
		super();
		this.reimbId = reimbId;
		this.description = description;
		this.status = status;
		this.amount = amount;
		this.ownerId = ownerId;
		this.receiptImage = receiptImage;
	}

	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public Blob getReceiptImage() {
		return receiptImage;
	}
	public void setReceiptImage(Blob receiptImage) {
		this.receiptImage = receiptImage;
	}
	
	public Reimbursement() {}
	public Reimbursement(String description, double amount, int ownerId, String creator) {
		super();
		this.description = description;
		this.amount = amount;
		this.ownerId = ownerId;
		this.creator = creator;
	}
	
}
