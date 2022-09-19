<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<div class="container col-md-3 col-md-offset-3" style="overflow: auto">
    <h1>Login</h1>
    <br>
    <form method='post' action='<%=response.encodeURL("j_security_check")%>'>
        <div class="form-group">
            <label for="uname">Username:</label> <input type="text"
                class="form-control"  placeholder="User Name"
                name="j_username" required>
        </div>

        <div class="form-group">
            <label for="uname">Password:</label> <input type="password"
                class="form-control"  placeholder="Password"
                name="j_password" required>
        </div>


        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>