

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uploadDetails(request, response);
	}


	private void uploadDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long studentId = request.getParameter("studentId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		float semester1 = request.getParameter("semester1");
		float semester2 = request.getParameter("semester2");
		float semester3 = request.getParameter("semester3");
		float semester4 = request.getParameter("semester4");
		float semester5 = request.getParameter("semester5");
		float semester6 = request.getParameter("semester6");

		User student = new Student();
		student.setname(name);
		student.setemail(email);
		student.setUsername(username);
		student.setPassword(password);

		try {
			int result = userDao.registerUser(user);
			if(result == 1) {
				request.setAttribute("NOTIFICATION", "Registration Successfull! Please login Now.");
			}
			else if(result==-1){
				request.setAttribute("NOTIFICATION", "Entered details already exists. Please login.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}
}