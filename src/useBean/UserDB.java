package useBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import javaBean.Message;
import javaBean.User;

public class UserDB {
	
	//ע��ʱ�ж��û����Ƿ����
	public static boolean UserExists(String username) {
		//���Խ���һ�����ӳر���һ�����������ӣ����ж�����Ҫ���ݿ�����ʱ��ֱ�ӽ�������ӷ��ظ��ö���
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String qr = "SELECT username FROM User "+ "WHERE username = ?";
		try {
			ps = connection.prepareStatement(qr);
			ps.setString(1, username);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
		
	}
	//��ע���û���Ϣ���������ݿ�
	public static int insert(User user) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		
		String qr = "INSERT INTO User (username, password)"+"VALUES (?, ?)";
		try { 
			
			ps = connection.prepareStatement(qr);
			ps.setString(1, user.getusername());
			ps.setString(2, user.getpassword());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		} 
		
	}
	
	//��¼ʱ����username����user
	public static User selectUser(String username) {
		//���Խ���һ�����ӳر���һ�����������ӣ����ж�����Ҫ���ݿ�����ʱ��ֱ�ӽ�������ӷ��ظ��ö���
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		//sql���
		String qr = "SELECT * FROM User "+ "WHERE username = ?";
		try {
			ps = connection.prepareStatement(qr);
			//sql������ʺŵĽ���
			ps.setString(1, username);
			rs = ps.executeQuery();
			User user = null;
			if (rs.next()) {
				user = new User ();
				//����userd��id,username,passward
				user.setid(rs.getString("id"));
				user.setusername(rs.getString("username"));
				user.setpassword(rs.getString("password"));
			}
			return user;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
			} finally {
				//�ر�PreparedStatement��ResultSet���ͷ����ӳ��д˴�����
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ps);
				pool.freeConnection(connection);
			}
	}
	
	
	
	//�����Ǹ���userid����user
		public static User selectUser1(String id) {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String qr = "SELECT * FROM User "+ "WHERE id = ?";
			try {
				ps = connection.prepareStatement(qr);
				ps.setString(1, id);
				rs = ps.executeQuery();
				User user = null;
				if (rs.next()) {
					user = new User ();
					user.setid(rs.getString("id"));
					user.setusername(rs.getString("username"));
					user.setpassword(rs.getString("password"));
				}
				return user;
			} catch (SQLException e) {
				System.out.println(e);
				return null;
			} finally {
				DBUtil.closeResultSet(rs);
				DBUtil.closePreparedStatement(ps);
				pool.freeConnection(connection);
			}
		}
	
		
	//���Խ����message���ж�����������
	public static List<Message> selectU() {
		List<Message> mL= new ArrayList<Message>();
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String qr = "SELECT * FROM Message ";
		try {
			ps = connection.prepareStatement(qr);
			rs = ps.executeQuery();
			Message m = null;
			while (rs.next()) {
				m = new Message ();
				m.setcontext(rs.getString("context"));
				m.setmid(rs.getString("mid"));
				m.settitle(rs.getString("title"));
				m.setuserid(rs.getString("userid"));
				mL.add(m);
			}
			
			return mL;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	
}


