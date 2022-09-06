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
	

	<h1>Enter Student Details and Marks</h1>
    <br>
    <br>
	<div class="container col-md-5">
			
			
				<form action="<%=request.getContextPath()%>/register" method="post">

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
						<label for="city">City:</label> <input type="text"
							class="form-control" placeholder="Enter City"
							name="city" required>
					</div>

					<div class="form-group">
						<label for="semester1">Semester 1:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 1 Marks"
							name="semester1" required>
					</div>
                    <div class="form-group">
						<label for="semester2">Semester 2:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 2 Marks"
							name="semester2" required>
					</div>
                    <div class="form-group">
						<label for="semester3">Semester 3:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 3 Marks"
							name="semester3" required>
					</div>
                    <div class="form-group">
						<label for="semester4">Semester 4:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 4 Marks"
							name="semester4" required>
					</div>
                    <div class="form-group">
						<label for="semester5">Semester 5:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 5 Marks"
							name="semester5" required>
					</div>
                    <div class="form-group">
						<label for="semester6">Semester 6:</label> <input type="number"
							class="form-control"  placeholder="Enter Semester 6 Marks"
							name="semester6" required>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
				<br>
    </div>

			
		
		
</body>
</html>