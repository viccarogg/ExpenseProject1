<html>
<body>
<% final class User {
	public String name;
	public int age;
	public User(int age) {
		this.name = "ezra";
		this.age = age;
	}
}

String[] users = {"george", "yong", "justin", "ezra"};
	%>

<% for(int i = 0; i < 4; i++) {
	 User u = new User(i);  %>
<h2>Hello <%= users[i] %> with age of <%= u.age %></h2>
<% } %>
</body>
</html>
