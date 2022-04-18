package db;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends DBServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {	
		super.service(req, resp);
		String username=req.getParameter("username");

		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String path="";
		if(username==null||password==null||email==null||username.equals("")||password.equals("")||email.equals(""))
			path="register.jsp";
			else{
				
				Object[] n={username};
				String sql1="select username from t_users where username = ?";
				try{
					rs=execSQL(sql1,n);
					if(rs.next()==true)
						{path="register.jsp";
						System.out.println("用户名已存在");}
							else{
								String npsd=Encrypt.EncryptMD5(password);
								String sql2 = "insert into t_users(username,password_md5,email) values(?,?,?)";
								Object[] upe = {username,npsd,email};
								execSQL(sql2, upe);
								path = "result.jsp";
								}
							}
			catch(Exception e){System.out.println(e.toString());}			
			}	
		req.getRequestDispatcher(path).forward(req, resp);
		}	
	}


