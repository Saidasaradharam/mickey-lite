<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Details</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


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

	<div class="row">


		<div class="container">
			<h3 class="text-center">Students Marks</h3>
			<hr>
			<div class="container text-left">
				<% 
				ServletContext servletcontext = getServletContext();
				String role = (String)servletcontext.getAttribute("role");
				if (role.equals("Principal")){
					
				%>
					<a href="<%=request.getContextPath()%>/upload"
						class="btn btn-info">Add New</a>
						<% }%>
				
			</div>
			<br>
			<table class="table table-bordered">
				<thead style=" position: sticky;
				top: 0; background-color: rgb(86, 86, 157);">
					<tr>
						<th>Name</th>
						<th>Semester 1</th>
						<th>Semester 2</th>
						<th>Semester 3</th>
						<th>Semester 4</th>
						<th>Semester 5</th>
						<th>Semester 6</th>
						<th>CGPA</th>
						<% 
						if (!role.equals("Student")){
						%>
						<th>Other Options</th>
						<% } %>
					</tr>
				</thead>
				<tbody>
			
					<c:forEach var="list" items="${studentslist}">

						<tr>
							<td><c:out value="${list.name}" /></td>
							<td><c:out value="${list.sem1}" /></td>
							<td><c:out value="${list.sem2}" /></td>
							<td><c:out value="${list.sem3}" /></td>
							<td><c:out value="${list.sem4}" /></td>
							<td><c:out value="${list.sem5}" /></td>
							<td><c:out value="${list.sem6}" /></td>
							<td><c:out value="${list.cgpa}" /></td>
							<% 
							if (!role.equals("Student")){
							%>
								<td><a href="edit?id=<c:out value='${list.studentid}' />">Update</a>
									
									<% 
									if (!role.equals("Staff")){
									%>	&nbsp;&nbsp;&nbsp;&nbsp; 
										<a href="delete?id=<c:out value='${list.studentid}' />">Delete</a>
									<% } %>
								</td>
							<% } %>
							
						</tr>
					</c:forEach>
					
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>