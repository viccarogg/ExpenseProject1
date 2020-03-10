package com.george.expenses.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.george.expenses.models.Reimbursement;

public class ReimbursementDB implements ReimbursementDAO {
	Connection conn = MyConnection.getMyConnInstance().getConn();
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	@Override
	public Collection<Reimbursement> getAllReimbursements() {
		Collection<Reimbursement> result = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM reimbursements";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				result.add(new Reimbursement(rs.getInt("reimbursement_id"),
											 rs.getString("description"),
											 rs.getString("status"),
											 rs.getDouble("total_amount"),
											 rs.getInt("employee_id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Reimbursement getReimbursement(int reimb_id) {
		Reimbursement result = null;
		String sql = "SELECT * FROM reimbursements WHERE reimbursement_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimb_id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = new Reimbursement(rs.getInt("reimbursement_id"),
											 rs.getString("description"),
											 rs.getString("status"),
											 rs.getDouble("total_amount"),
											 rs.getInt("employee_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Collection<Reimbursement> getReimbursements(String status) {
		Collection<Reimbursement> result = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM reimbursements WHERE status=?";
		try {
			if(status.equals("RESOLVED")) {
				sql="SELECT * FROM reimbursements WHERE status!='PENDING'";
				pstmt = conn.prepareStatement(sql);				
			}
			else {
				pstmt = conn.prepareStatement(sql);		
				pstmt.setString(1, status);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next())
				result.add(new Reimbursement(rs.getInt("reimbursement_id"),
											 rs.getString("description"),
											 rs.getString("status"),
											 rs.getDouble("total_amount"),
											 rs.getInt("employee_id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Collection<Reimbursement> getReimbursementsByEmployee(int emp_id) {
		Collection<Reimbursement> result = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM reimbursements WHERE employee_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				result.add(new Reimbursement(rs.getInt("reimbursement_id"),
											 rs.getString("description"),
											 rs.getString("status"),
											 rs.getDouble("total_amount"),
											 rs.getInt("employee_id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Collection<Reimbursement> getReimbursementsByEmployeeAndStatus(int emp_id, String status) {
		Collection<Reimbursement> result = new ArrayList<Reimbursement>();
		String sql = "SELECT * FROM reimbursements WHERE employee_id=? AND status=?";
		try {
			if(status.equals("RESOLVED")) {
				sql="SELECT * FROM reimbursements WHERE employee_id=? status!='PENDING'";
				pstmt = conn.prepareStatement(sql);				
				pstmt.setInt(1, emp_id);
			}
			else {
				pstmt = conn.prepareStatement(sql);		
				pstmt.setInt(1, emp_id);
				pstmt.setString(2, status);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next())
				result.add(new Reimbursement(rs.getInt("reimbursement_id"),
											 rs.getString("description"),
											 rs.getString("status"),
											 rs.getDouble("total_amount"),
											 rs.getInt("employee_id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void createReimbursement(Reimbursement reimb) {
		String sql = "{call reimbursement_insert(?,?,?,?)}";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reimb.getDescription());
			pstmt.setDouble(2, reimb.getAmount());
			pstmt.setInt(3, reimb.getOwnerId());
			pstmt.setString(4, reimb.getCreator());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void reviewReimbursement(int reimb_id, String status) {
		String sql = "{call review_reimb(?,?)";
		
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, reimb_id);
			cstmt.setString(2, status);
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
