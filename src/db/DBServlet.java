package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	private
	String user="root";
	String psd="123";
	String url="jdbc:mysql://localhost:3306/mydata?characterEncoding=UTF-8";
	String driver="org.gjt.mm.mysql.Driver"; 
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			if(con==null){
				Class.forName(driver);//��������
				 con = DriverManager.getConnection(url, user, psd);//��������
			}
			}catch(ClassNotFoundException e1){
				System.out.println("���ݿⲻ����");
				System.out.println(e1.toString());
			}
			catch(SQLException e2){
				System.out.println("���ݿ��쳣");
				System.out.println(e2.toString());
			}		
			}
	protected ResultSet execSQL(String sql,Object[] args){
		try{
		pstmt=con.prepareStatement(sql);//��sql��䴴��ps����
		for(int i=0;i < args.length;i++){
    		pstmt.setObject(i+1, args[i]);    //����SQL����ֵ��ʹ�ø�����������ָ��������ֵ,JDBC �淶ָ����һ���� Java Object ���͵� SQL ���͵ı�׼ӳ���ϵ���ڷ��͵����ݿ�֮ǰ��������������ת��Ϊ��Ӧ SQL ���͡�
    	}
    	pstmt.execute();        //ִ��SQL���
    	
    	rs= pstmt.getResultSet();
		
		}catch(SQLException e){System.out.println(e.toString());}
		return rs;//���ؽ���������ִ�е�SQL��䲻���ؽ�������򷵻�null
	}
	
	public void destroy() {//�ر�����
		try
	       {
	          if(con!=null) 
	        	  con.close();
	        }
	        catch(Exception e){
	              System.out.println(e.toString());
	            }
	}

	
}
