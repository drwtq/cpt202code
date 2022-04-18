package Sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaBean.User;
import useBean.UserDB;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message ="";
       
    public RegistServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		String url ="register.jsp";
		
		if(action.equals("regist")) 
			url = registerUser(request,response);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	private String registerUser(HttpServletRequest request,HttpServletResponse response) {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String message = "";
	
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setusername (username); 
		user.setpassword(password);
		String url = "/login.jsp";
		if(password.equals(password2))
		{
			if( !UserDB.UserExists(username) ) {
				message = "Registration successful! and login in";
				session.setAttribute("message", message);
			
				UserDB.insert(user);
				return url;
			}
			else
			{
				message = "The user name already exists";
				url = "/register.jsp";
				session.setAttribute("message", message);
				return url;
			}
		}
		else 
		{
			message = "The password is inconsistent";
			session.setAttribute("message", message);
			url = "/register.jsp";
			return url;
		}
	}
}
