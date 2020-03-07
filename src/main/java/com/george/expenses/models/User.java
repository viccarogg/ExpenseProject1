package com.george.expenses.models;

public abstract class User {
	private int id;
	private String username;
	private String password;
	private String role;
	private int manager_id;
	
	public String toJsonString() {
		String result = "{'user_id':'"+id+"',"
				+ "'username':'"+username+"',"
				+ "'password':'"+password+"',"
				+ "'role':'"+role+"',"
				+ "'manager_id':'"+manager_id+"'}";
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", manager_id=" + manager_id + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public User(int id, String username, String password, String role, int manager_id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.manager_id = manager_id;
	}
	
	
}
