<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Front Page</title>
<link rel="stylesheet" href="/style.css" />
</head>
	<body>
		<h1>Let's get shit done!</h1>
	
		<p class="message">${ message }</p>
	<p>
	<a href="/login" class="btn btn-light btn-sm">Login</a>
	</p>
	<c:if test="${ not empty user }">
		<p>Would you like to <a href="/add-task">Add a task</a>.</p>
		<p>Would you like to <a href="/tasks">See your tasks</a>.</p>
	</c:if>
	
	</body>
</html>