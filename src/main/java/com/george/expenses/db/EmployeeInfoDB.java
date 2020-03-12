package com.george.expenses.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.george.expenses.models.EmployeeInfo;



public class EmployeeInfoDB implements EmployeeInfoDAO {
	Connection conn = MyConnection.getMyConnInstance().getConn();
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	@Override
	public EmployeeInfo getMyInformation(int emp_id) {
		EmployeeInfo result = null;
		String sql = "SELECT * FROM employee_info WHERE employee_id=?";
		String date = "2000-01-01";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getDate("date_of_birth") != null)
					date = rs.getDate("date_of_birth").toString();
				result = new EmployeeInfo(rs.getString("first_name"),
										  rs.getString("last_name"), 
										  rs.getString("email"), 
										  date, 
										  rs.getString("address"), 
										  rs.getString("phone"));
				result.setSalary(rs.getDouble("salary"));
				result.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return result;
	}

	@Override
	public void updateMyInformation(EmployeeInfo info) {
		String sql = "{call update_info(?,?,?,?,?,?,?,?)}";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, info.getEmpId());
			cstmt.setString(2, info.getFirstName());
			cstmt.setString(3, info.getLastName());
			cstmt.setString(4,  info.getEmail());
			cstmt.setDate(5, Date.valueOf(info.getDob()));
			cstmt.setString(6, info.getAddress());
			cstmt.setString(7, info.getPhone());
			cstmt.setString(8, info.getModified());
			
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
