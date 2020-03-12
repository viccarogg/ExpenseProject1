<%@ include file="partials/head.jsp" %>
<div class="container">
	<div class="rounded d-flex justify-content-center pb-3" id="main">
		<div>
			<h1>GEORGE, LLC. Company Reimbursement Portal</h1>
			<form action="login" method="POST">
				<div class="form-group">
					<label for="usernameInput">Username:</label>
					<input type="text" name="uname" id="usernameInput" placeholder="Username" class="form-control">
				</div>
				<div class="form-group">
					<label for="passwordInput">Password:</label>
					<input type="password" name="pass" id="passwordInput" placeholder="Password" class="form-control">
				</div>
				<div class="form-group">
					<label for="roleInput">Login as: </label>
					<select type="select" name="role" id="roleInput" class="form-control">
						<option value="Employee" selected>Employee</option>
						<option value="Manager">Manager</option>
					</select>
				</div>
				<input type="submit" id="userpass" class="btn btn-primary form-control">
			</form>
		</div>
	</div>

</div>

<%@ include file="partials/foot.jsp" %>