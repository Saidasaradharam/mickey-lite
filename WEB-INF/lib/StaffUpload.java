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




@WebServlet("/staffUpload")
public class StaffUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	RegistrationDao RegistrationDaoobj = new RegistrationDao();
	public void init() {
		studentDao = new StudentDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uploadDetails(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect("upload.jsp");
        ServletContext servletcontext = getServletContext();
	    String role = (String)servletcontext.getAttribute("role");
        if (!role.equals("Principal")){
		    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");	
            dispatcher.forward(request, response);
	   }
       else{
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff-upload.jsp");
		dispatcher.forward(request, response);
	    }
    }
	private void uploadDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
        String role = request.getParameter("role");
		RegistrationDaoobj.register(name,email,password,role);

	}
}