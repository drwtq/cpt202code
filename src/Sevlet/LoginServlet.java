package Sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaBean.Message;
import javaBean.User;
import useBean.UserDB;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message="";
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/login.jsp";
		String action = request.getParameter("action");
		System.out.println("action: " + action);
		
		request.setCharacterEncoding("utf-8");
		
		if(action == null)
			url="/login.jsp";
		else if(action.equals("login"))
	
			url = login(request,response);
	
		request.setAttribute("message", message);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		String userid="";
		
		User user = UserDB.selectUser(username);

		String url = "/register.jsp";
		if(user != null) {
		
			if(user.getpassword().equals(password)) {
				
				Cookie u = new Cookie("userid",username);
				
				u.setMaxAge(60*60*24*365*2);
				
				u.setPath("/");
				
				response.addCookie(u);
				
				userid = user.getid();
				session.setAttribute("userid", userid);
				
				
				
			}
			else {
				message = "Wrong password";
				url="/login.jsp";
			}
		}
		else {
			message = "The user does not exist";
			url = "/login.jsp";
		}
		return url;		
	}	
}
