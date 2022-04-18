package useBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import javaBean.Message;


public class MessageDB {
	
	
	//留言写入数据库
	public static int insert(Message message) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		//插入语句
		String qr = "INSERT INTO Message (userid, title, context)"+"VALUES (?, ?, ?)";
		try { 
			ps = connection.prepareStatement(qr);
			ps.setString(1, message.getuserid());
			ps.setString(2, message.gettitle());
			ps.setString(3, message.getcontext());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		} 
		
	}

	//通过用户ID寻找其的留言
	public static Message selectMessage(String userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String qr = "SELECT * FROM Message "+ "WHERE userid = ?";
		try {
			ps = connection.prepareStatement(qr);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			Message message = null;
			if (rs.next()) {
				message = new Message ();
				message.setmid(rs.getString("mid"));
				message.setuserid(rs.getString("userid"));
				message.settitle(rs.getString("title"));
				message.setcontext(rs.getString("context"));
			}
			
			return message;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	//通过留言的mid找到留言的主题和内容
	public static Message selectMessagem(String mid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String qr = "SELECT * FROM Message "+ "WHERE mid = ?";
		try {
			ps = connection.prepareStatement(qr);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			Message message = null;
			if (rs.next()) {
				message = new Message ();
				message.setmid(rs.getString("mid"));
				message.setuserid(rs.getString("userid"));
				message.settitle(rs.getString("title"));
				message.setcontext(rs.getString("context"));
			}
			
			return message;
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
