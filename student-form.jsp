<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit/Update</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #6a6aa1">


			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/"
					class="nav-link">Home</a></li>
				
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>


			</ul>
		</nav>
	</header>

	<h3 class="text-center">Update Details</h3>
	<div class="container text-right">

		<a href="<%=request.getContextPath()%>/list"
			class="btn btn-info">Go Back</a>
	</div>
	<hr>
	<div class="container col-md-5">
			

				<form action="<%=request.getContextPath()%>/update" method="post">

                    <input type="hidden" name="id" value="<c:out value='${student.studentid}' />" />

					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
                            value="<c:out value='${student.name}' />" class="form-control"
							name="name" required>
					</div>

					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
                            value="<c:out value='${student.email}' />" class="form-control" 
							name="email" required>
					</div>


					<div class="form-group">
						<label for="semester1">Semester 1:</label> <input type="number"
                            value="<c:out value='${student.sem1}' />" class="form-control" 
							name="semester1" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester2">Semester 2:</label> <input type="number"
						    value="<c:out value='${student.sem2}' />" 	class="form-control" 
							name="semester2" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester3">Semester 3:</label> <input type="number"
                            value="<c:out value='${student.sem3}' />" class="form-control" 
							name="semester3" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester4">Semester 4:</label> <input type="number"
                        value="<c:out value='${student.sem4}' />"  class="form-control" 
							name="semester4" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester5">Semester 5:</label> <input type="number"
                        value="<c:out value='${student.sem5}' />"  class="form-control" 
							name="semester5" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester6">Semester 6:</label> <input type="number"
                        value="<c:out value='${student.sem6}' />"  class="form-control"  
							name="semester6" step="0.01" required>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
				<br>
    </div>

			
		
		
</body>
</html>