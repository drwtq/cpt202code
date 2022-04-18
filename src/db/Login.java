package db;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends DBServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		//调用父类的service()连接数据库
		super.service(req, resp);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String path="";
		//判断输入内容是否合法
		if(!(username.equals(""))&&!(password.equals("")&&!(username==null)&&!(password==null))){
			Object n[]={username};
			try {
			String npsd=Encrypt.EncryptMD5(password);
			//将密码转换为MD5加密后的密码
			String sql = "select username, password_md5 from t_users where username = ?";
			//执行sql语句获取结果集
			ResultSet rs=execSQL(sql,n);
			//获取数据库中的密码，判断密码是否正确
				if(rs.next()==true&&rs.getString("password_md5").equals(npsd))
					path="/WEB-INF/pages/main.jsp";
				else
					path="login.jsp";
					System.out.println("用户名或密码错误");			    
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(NoSuchAlgorithmException e1){
				e1.printStackTrace();
			}
		}
		else{
			path="login.jsp";//这一步无论如何都不执行是因为if语句的问题不仅要判空还要equals
			System.out.println("请输入用户名和密码");
		}
		 	//根据不同结果请求转发到相应页面
	    	req.getRequestDispatcher(path).forward(req, resp);	    		
	}	
}//else后面如果不打括号则只默认执行一句当做else的内容
		