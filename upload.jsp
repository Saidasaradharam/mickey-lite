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
	
	<h3 class="text-center">Students Marks</h3>
	<h5 class="text-center">Add Record</h5>
	<div class="container text-right">

		<a href="<%=request.getContextPath()%>/list"
			class="btn btn-info">View All</a>
	</div>
	<hr>
	<div class="container col-md-5">
			

				<form action="<%=request.getContextPath()%>/upload" method="post">

                    <div class="form-group">
						<label for="studentId">Student ID:</label> <input type="number"
							class="form-control" placeholder="Enter Student ID"
							name="studentId" required>
					</div>

					<div class="form-group">
						<label for="name">Name:</label> <input type="text"
							class="form-control" placeholder="Enter Name"
							name="name" required>
					</div>

					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control"  placeholder="Enter Email "
							name="email" required>
					</div>


					<div class="form-group">
						<label for="semester1">Semester 1:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 1 GPA"
							name="semester1" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester2">Semester 2:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 2 GPA"
							name="semester2" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester3">Semester 3:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 3 GPA"
							name="semester3" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester4">Semester 4:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 4 GPA"
							name="semester4" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester5">Semester 5:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 5 GPA"
							name="semester5" step="0.01" required>
					</div>
                    <div class="form-group">
						<label for="semester6">Semester 6:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 6 GPA"
							name="semester6" step="0.01" required>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
				<br>
    </div>

			
		
		
</body>
</html>