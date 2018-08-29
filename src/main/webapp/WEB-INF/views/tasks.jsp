<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
list of tasks here

<p>
		<h1>Are you ready to get your shit done?</h1>
	
		<table class="table">
		<tbody>
			<thead>
				<tr>
					<th>Task</th><th>Due Date</th><th>Complete?</th>
				</tr>
			</thead>
			
				<c:forEach var="task" items="${tasks}">
				<tr>							
					
					<td>${task.description}</td><td>${task.dueDate}</td><td>${item.complete}</td>
					<td>
						 <div class="col-auto my-1">
						      <div class="custom-control custom-checkbox mr-sm-2">
						        <a onclick="return confirm('Are you sure you want to mark this complete?')"href="/tasks/${ task.id }/edit" class="btn btn-light btn-sm">Complete</a> 
						        <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
						        <label class="custom-control-label" for="customControlAutosizing">Mark as Complete?</label>
						      </div>
						  </div>
						  <div class="col-auto my-1">
						      <button type="submit" class="btn btn-primary">Submit</button>
						  </div>
					
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/add-task" class="btn btn-light btn-sm">Add</a>
	</body>

</html>