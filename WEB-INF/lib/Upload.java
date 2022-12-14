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





@WebServlet("/upload")
public class Upload extends HttpServlet {
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
		
		ServletContext servletcontext = getServletContext();
	    String role = (String)servletcontext.getAttribute("role");
        if (role.equals("Student") || role.equals("Staff")){
		    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");	
            dispatcher.forward(request, response);
	   }
	   else{
		RequestDispatcher dispatcher = request.getRequestDispatcher("upload.jsp");
		dispatcher.forward(request, response);
		}
	}
	private void uploadDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long studentId = Long.parseLong(request.getParameter("studentId"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		float semester1 = Float.parseFloat(request.getParameter("semester1"));
		float semester2 = Float.parseFloat(request.getParameter("semester2"));
		float semester3 = Float.parseFloat(request.getParameter("semester3"));
		float semester4 = Float.parseFloat(request.getParameter("semester4"));
		float semester5 = Float.parseFloat(request.getParameter("semester5"));
		float semester6 = Float.parseFloat(request.getParameter("semester6"));
		
		RegistrationDaoobj.register(name,email,password,"Student");

		Student student = new Student();
		student.setstudentid(studentId);
		student.setname(name);
		student.setemail(email);
		student.setsem1(semester1);
		student.setsem2(semester2);
		student.setsem3(semester3);
		student.setsem4(semester4);
		student.setsem5(semester5);
		student.setsem6(semester6);

		try {
			int result = studentDao.registerUser(student);
			System.out.println("Result is : "+result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("list");
		
	}
}