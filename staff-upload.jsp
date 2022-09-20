<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

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

    <%  ServletContext servletcontext = getServletContext();
		String role = (String)servletcontext.getAttribute("role");
		if (!role.equals("Principal")){
			response.sendRedirect("list");
        }
   	%>


	<h3 class="text-center">Staff</h3>
	<h5 class="text-center">Add Record</h5>
	<div class="container text-right">

		<a href="<%=request.getContextPath()%>/list"
			class="btn btn-info">View All</a>
	</div>
	<hr>
	<div class="container col-md-5">
			

				<form action="<%=request.getContextPath()%>/staffUpload" method="post">


					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" placeholder="Enter Name"
							name="name" required>
					</div>

                    <div class="form-group">
                        <label>Role</label> <select class="form-control"
                            name="role" >
                            <option value="">Select an Option </option>
                            <option value="Hod">HoD</option>
                            <option value="Staff">Staff</option>
                        </select>
                    </div>

					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control"  placeholder="Enter Email"
							name="email" required>
					</div>

					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control"  placeholder="Enter Password"
							name="password" required>
					</div>


					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
				<br>
    </div>

			
		
		
</body>
</html>