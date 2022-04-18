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
		//���ø����service()�������ݿ�
		super.service(req, resp);
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String path="";
		//�ж����������Ƿ�Ϸ�
		if(!(username.equals(""))&&!(password.equals("")&&!(username==null)&&!(password==null))){
			Object n[]={username};
			try {
			String npsd=Encrypt.EncryptMD5(password);
			//������ת��ΪMD5���ܺ������
			String sql = "select username, password_md5 from t_users where username = ?";
			//ִ��sql����ȡ�����
			ResultSet rs=execSQL(sql,n);
			//��ȡ���ݿ��е����룬�ж������Ƿ���ȷ
				if(rs.next()==true&&rs.getString("password_md5").equals(npsd))
					path="/WEB-INF/pages/main.jsp";
				else
					path="login.jsp";
					System.out.println("�û������������");			    
			} catch (SQLException e) {
				e.printStackTrace();
			}catch(NoSuchAlgorithmException e1){
				e1.printStackTrace();
			}
		}
		else{
			path="login.jsp";//��һ��������ζ���ִ������Ϊif�������ⲻ��Ҫ�пջ�Ҫequals
			System.out.println("�������û���������");
		}
		 	//���ݲ�ͬ�������ת������Ӧҳ��
	    	req.getRequestDispatcher(path).forward(req, resp);	    		
	}	
}//else�����������������ֻĬ��ִ��һ�䵱��else������
		