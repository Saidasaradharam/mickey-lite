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


@WebServlet("/logout")
public class LogoutController extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        request.getSession().invalidate();
        
    }
}