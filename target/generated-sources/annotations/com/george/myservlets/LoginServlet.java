package com.george.myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.george.expenses.db.EmployeeDAO;
import com.george.expenses.db.EmployeeDB;
import com.george.expenses.models.Employee;
import com.george.expenses.models.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login failed");
		response.sendRedirect("/project1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Client client = ClientBuilder.newClient();
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String role = request.getParameter("role");
		System.out.println(username + password);
		EmployeeDAO empdb = new EmployeeDB();
		
		User user = null;
		if(role.equals("Employee"))
			user = empdb.loginEmployee(username, password);
		else
			user = empdb.loginManager(username, password);
		
		if(user != null) {
			System.out.println(user);			

			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			response.sendRedirect("home.jsp");
		}
		else {
			doGet(request, response);
		}
	}

}
