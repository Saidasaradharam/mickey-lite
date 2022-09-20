package student;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.adventnet.persistence.*; 




@WebServlet("/")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	Schedule scheduleObj = new Schedule();
	RegistrationDao RegistrationDaoobj = new RegistrationDao();
	public void init() {
		studentDao = new StudentDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		ServletContext servletcontext = getServletContext();
		String role = (String)servletcontext.getAttribute("role");
		try {
			switch (action) {
			case "/list":
				listStudents(request, response);
				break;
			case "/delete":
				if (role.equals("Staff") || role.equals("Student")){
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
				else{
					deleteStudent(request, response);
				}
				break;
			 case "/edit":
			 	if (role.equals("Student")){
					response.sendRedirect("list");
				}
				else{
			 		showEditForm(request, response);
				}
			 	break;
			 case "/update":
			 	if (role.equals("Student")){
					response.sendRedirect("list");
				}
				else{
			 		updateStudent(request, response);
				}
				break;
			
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}


	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		try{

			ServletContext servletcontext = getServletContext();
			String role = (String)servletcontext.getAttribute("role");
			if (role.equals("Student")){
				System.out.println("It is student inside list controller");
				List<Student> studentslist = studentDao.showStudent(request.getUserPrincipal().getName());
				request.setAttribute("studentslist", studentslist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
				dispatcher.forward(request, response);
				
			
			}else{
				System.out.println("It is not student inside list controller");
				List<Student> studentslist = studentDao.showAll();
				request.setAttribute("studentslist", studentslist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
				dispatcher.forward(request, response);
			}
			
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		long studentId = Long.parseLong(request.getParameter("id"));
		studentDao.deleteStudent(studentId);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long studentId = Long.parseLong(request.getParameter("id"));
		Student existingStudent = studentDao.selectStudent(studentId);
		System.out.println(existingStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}


	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		long studentId = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		float semester1 = Float.parseFloat(request.getParameter("semester1"));
		float semester2 = Float.parseFloat(request.getParameter("semester2"));
		float semester3 = Float.parseFloat(request.getParameter("semester3"));
		float semester4 = Float.parseFloat(request.getParameter("semester4"));
		float semester5 = Float.parseFloat(request.getParameter("semester5"));
		float semester6 = Float.parseFloat(request.getParameter("semester6"));
		float cgpa = Float.parseFloat(String.format("%.2f",((semester1+semester2+semester3+semester4+semester5+semester6)/6)));
		Student updateStudent = new Student(studentId,name,email,semester1,semester2,semester3,semester4,semester5,semester6,cgpa);
		
		studentDao.updateStudent(updateStudent);
		
		response.sendRedirect("list");
	}

	
}