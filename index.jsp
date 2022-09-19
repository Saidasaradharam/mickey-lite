<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: grey">


			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	


	<div align="center">
		<h1>Home</h1>
		<br>
		<br>
	</div>
    		<br>
        <div align="center">

            <a href="<%=request.getContextPath()%>/upload"
                class="btn btn-info">Add a Member</a>
                <br>
        </div>
        <div align="center">
            <br>
            <a href="<%=request.getContextPath()%>/list"
                class="btn btn-info">List all Students</a>
        </div>

        <div align="center">
            <br>
            <a href="<%=request.getContextPath()%>/logout"
                class="btn btn-danger">Logout</a>
        </div>
    
</body>
</html>