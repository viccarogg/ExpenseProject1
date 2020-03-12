<%@ include file="partials/head.jsp" %>

<%@ page import="com.george.expenses.models.User" %>
<div class="container">
	<div class="rounded d-flex justify-content-center pb-3 pr-3 pl-3 pt-3" id="main">
		<% User u = null;
		try { 
			u = (User) request.getSession().getAttribute("currentUser"); 
			if(u.getRole().equals("EMPLOYEE")) { %>
		<div id="welcomeUser" class="w-100" data-id="<%= u.getId()%>" data-role="<%= u.getRole()%>">
			<h1>Welcome <%= u.getUsername() %></h1>
			<%@ include file="partials/emp-home.jsp" %>
		</div>
		<% } else { %>
		<div id="welcomeUser" class="w-100" data-id="<%= u.getId()%>" data-role="<%= u.getRole()%>">
			<h1>Welcome <%= u.getUsername() %> </h1>
			<%@ include file="partials/man-home.jsp" %>
		</div>
		<% }
		} catch (NullPointerException e) { response.sendRedirect("/project1"); } %>
	</div>


</div>

<%@ include file="partials/foot.jsp" %>