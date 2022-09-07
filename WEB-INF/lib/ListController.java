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

		try {
			switch (action) {
			// case "/delete":
			// 	deleteTodo(request, response);
			// 	break;
			// case "/edit":
			// 	showEditForm(request, response);
			// 	break
			// case "/update":
			// 	updateTodo(request, response);
			// 	break;
			case "/list":
				listStudents(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		try{
			List<Student> studentslist = studentDao.showAll();
			request.setAttribute("studentslist", studentslist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
			dispatcher.forward(request, response);
			
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}

	// private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	// 		throws SQLException, ServletException, IOException {
	// 	int id = Integer.parseInt(request.getParameter("id"));
	// 	Todo existingTodo = todoDAO.selectTodo(id);
	// 	RequestDispatcher dispatcher = request.getRequestDispatcher("todo-form.jsp");
	// 	request.setAttribute("todo", existingTodo);
	// 	dispatcher.forward(request, response);

	// }


	// private void updateTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
	// 	ServletContext servletcontext = getServletContext();
	// 	String username = (String)servletcontext.getAttribute("username");
	// 	String description = request.getParameter("description");
	// 	int id = Integer.parseInt(request.getParameter("id"));
	// 	String title = request.getParameter("title");
	// 	LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		
	// 	int status_id = Integer.parseInt(request.getParameter("status_id"));
	// 	Todo updateTodo = new Todo(id, title, username, description, targetDate, status_id);
		
	// 	todoDAO.updateTodo(updateTodo);
		
	// 	response.sendRedirect("list");
	// }

	// private void deleteTodo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	// 	int id = Integer.parseInt(request.getParameter("id"));
	// 	todoDAO.deleteTodo(id);
	// 	response.sendRedirect("list");
	// }
}