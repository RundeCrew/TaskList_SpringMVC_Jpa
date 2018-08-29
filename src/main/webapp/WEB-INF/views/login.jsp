<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

	<body>
	
	
	<h1>Login</h1>
		
		<p class="message">${ message }</p>
		
		<form action="/login" method="post">
		<p>
			<label for="name">Name:</label> <input id="name" name="name" value="${ param.name }" required minlength="2" />
		</p>
		<p>
			<label for="email">Email:</label> <input id="email" name="email" value="${ param.email }" required minlength="2" />
		</p>		
		<p>
			<label for="password">Password:</label> <input id="password" type="password" name="password" required minlength="2" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
	
	</body>
</html>