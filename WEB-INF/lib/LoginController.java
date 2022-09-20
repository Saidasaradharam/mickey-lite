package student;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				ServletContext servletcontext = getServletContext();
				if (request.isUserInRole("Student")) {
					System.out.println("Succesfully setted the servlet context role");
					
					servletcontext.setAttribute("role", "Student");
					response.sendRedirect("list");
					//response.sendRedirect("list");
				} else if (request.isUserInRole("Staff")){
					servletcontext.setAttribute("role", "Staff");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");	
					dispatcher.forward(request, response);

				} else if (request.isUserInRole("Hod")){
					servletcontext.setAttribute("role", "Hod");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");	
					dispatcher.forward(request, response);
				}
				 else if (request.isUserInRole("Principal")){
					servletcontext.setAttribute("role", "Principal");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");	
					dispatcher.forward(request, response);
				}
				
				
	}

	// protected void doPost(HttpServletRequest request, HttpServletResponse response)
	// 		throws ServletException, IOException {
	// 	loginDetails(request, response);
	// }
	
	// private void loginDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	// 	System.out.println("INside Login Details function present in  Login Controller");
	// 	ServletContext servletcontext = getServletContext();
	// 	if (request.isUserInRole("Student")) {
	// 		System.out.println("Succesfully setted the servlet context role");
			
	// 		servletcontext.setAttribute("role", "Student");
	// 		response.sendRedirect("list");
	// 	} else if (request.isUserInRole("Staff")){
			
	// 		servletcontext.setAttribute("role", "Staff");
	// 	} else if (request.isUserInRole("Hod")){
			
	// 		servletcontext.setAttribute("role", "Hod");
	// 	} else if (request.isUserInRole("Principal")){
			
	// 		servletcontext.setAttribute("role", "Principal");
	// 	}
		
	// }
}