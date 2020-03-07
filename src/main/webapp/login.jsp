<%@ include file="partials/head.jsp" %>
	<div class="container" id="main">
    <h1>Employee Portal</h1>
    <form action="login" method="POST">
		Username: <input type="text" name="uname">
		Password: <input type="password" name="pass">    
		Login as: <select type="select" name="role"> 
			<option value="Employee" selected>Employee</option>
			<option value="Manager">Manager</option>
		</select>
		<input type="submit" id="userpass">
    </form>
    <button type="button" id="login">Login as george</button>
	</div>
	
<%@ include file="partials/foot.jsp" %>
