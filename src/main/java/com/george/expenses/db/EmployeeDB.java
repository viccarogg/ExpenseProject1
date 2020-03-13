package com.george.expenses.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;

import com.george.expenses.models.Employee;
import com.george.expenses.models.Manager;
import com.george.expenses.models.User;

public class EmployeeDB implements EmployeeDAO {
	Connection conn = MyConnection.getMyConnInstance().getConn();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Employee loginEmployee(String username, String password) {
		Employee result = null;
		String sql = "SELECT * FROM employees WHERE username=? AND password=? AND role>=0";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// employee matched these credentials. if not then this returns null.
				result = new Employee(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"),
						rs.getInt("manager_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public Manager loginManager(String username, String password) {
		Manager result = null;
		String sql = "SELECT * FROM employees WHERE username=? AND password=? AND role=1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// employee matched these credentials. if not then this returns null.
				result = new Manager(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"),
						rs.getInt("manager_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Employee getEmployee(int emp_id) {
		Employee result = null;
		String sql = "SELECT * FROM employees WHERE employee_id=? AND role>=0";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			System.out.println(emp_id);

			if (rs.next()) {
				// employee matched these credentials. if not then this returns null.
				result = new Employee(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"),
						rs.getInt("manager_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public Manager getManager(int emp_id) {
		Manager result = null;
		String sql = "SELECT * FROM employees WHERE employee_id=? AND role=1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// employee matched these credentials. if not then this returns null.
				result = new Manager(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"),
						rs.getInt("manager_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public Collection<User> getAllEmployees() {
		Collection<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM employees";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if(rs.getInt("role") == 0)
					result.add(new Employee(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"), 
							rs.getInt("manager_id")));
				else
					result.add(new Manager(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"), 
							rs.getInt("manager_id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public Collection<Employee> getMyEmployees(int emp_id) {
		Collection<Employee> result = new ArrayList<Employee>();
		String sql = "SELECT * FROM employees WHERE manager_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// employee matched these credentials. if not then this returns null.
				result.add(new Employee(rs.getInt("employee_id"), rs.getString("username"), rs.getString("password"),
						rs.getInt("manager_id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
}
