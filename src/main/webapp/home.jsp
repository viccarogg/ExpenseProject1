<%@ include file="partials/head.jsp" %>

<%@ page import="com.george.expenses.models.User" %>

<% User u = null;
	try { 
		u = (User) request.getSession().getAttribute("currentUser"); 
		if(u.getRole().equals("EMPLOYEE")) { %>
			<h1>Welcome <%= u.getUsername() %> as  <%= u.getRole() %></h1>
	 <% } else { %>
			<h1>Welcome  <%= u.getUsername() %> you are the MAN"</h1>
	 <% }
	} catch (NullPointerException e) { response.sendRedirect("/project1"); } %>

<%@ include file="partials/foot.jsp" %>