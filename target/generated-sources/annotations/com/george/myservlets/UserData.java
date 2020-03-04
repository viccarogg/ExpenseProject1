package com.george.myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class UserData
 */
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Connection conn = null;
		
		try {
			
		OracleDataSource ods = new OracleDataSource();
		ods.setServerName("localhost");
		ods.setServiceName("orcl");
		ods.setDriverType("thin");
		ods.setPortNumber(1521);
		ods.setUser("bank_admin");
		ods.setPassword("admin");
		
		conn = ods.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "george");
			pstmt.setString(2, "password1");
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			
//			JSONArray jsonArr = new JSONArray();
			if(rs.next()) {
				JSONObject jsonObj = new JSONObject();
				for(int i = 1; i <= colCount; i++) {
					
					String key = rsmd.getColumnName(i);
					String val = rs.getString(key);
					jsonObj.put(key, val);
				}

			out.print(jsonObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		InputStream body = request.getInputStream();
//		body.
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		System.out.println(uname + "," + pass);
		System.out.println("here");
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		Connection conn = null;
		
		try {
			
		OracleDataSource ods = new OracleDataSource();
		ods.setServerName("localhost");
		ods.setServiceName("orcl");
		ods.setDriverType("thin");
		ods.setPortNumber(1521);
		ods.setUser("bank_admin");
		ods.setPassword("admin");
		
		conn = ods.getConnection();
		System.out.println("here1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			response.setStatus(201);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			System.out.println("here2");
			
//			JSONArray jsonArr = new JSONArray();
			if(rs.next()) {
				JSONObject jsonObj = new JSONObject();
				for(int i = 1; i <= colCount; i++) {
					
					String key = rsmd.getColumnName(i);
					String val = rs.getString(key);
					System.out.println(key + ": " + val);
					jsonObj.put(key, val);
				}

				System.out.println(jsonObj);
			out.print(jsonObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
