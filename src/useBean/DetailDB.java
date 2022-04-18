package useBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionPool.ConnectionPool;
import connectionPool.DBUtil;
import javaBean.Detail;


public class DetailDB {
	//将用户评论保存至数据库
	public static int insert(Detail detail) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		
		String qr = "INSERT INTO Detail (mid, cuser, comment, ctime)"+"VALUES (?, ?, ?, ?)";
		try { 
			ps = connection.prepareStatement(qr);
			ps.setString(1, detail.getmid());
			ps.setString(2, detail.getcuser());
			ps.setString(3, detail.getcomment());
			ps.setDate(4, detail.getctime());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		} 
		
	}

	
	public static Detail selectDetail(String userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM Detail "+ "WHERE userid = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			Detail detail = null;
			if (rs.next()) {
				detail = new Detail();
				detail.setmid(rs.getString("mid"));
				detail.setcuser(rs.getString("cuser"));
				detail.setcomment(rs.getString("comment"));
				detail.setctime(rs.getDate("ctime"));
			}
			
			return detail;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			DBUtil.closeResultSet(rs);
			DBUtil.closePreparedStatement(ps);
			pool.freeConnection(connection);
		}
	}
	

	//提交评论返回其他用户的评论
	public static List<Detail> selectU() {
		List<Detail> mL= new ArrayList<Detail>();
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String qr = "SELECT * FROM detail";
		try {
			ps = connection.prepareStatement(qr);
			rs = ps.executeQuery();
			Detail m = null;
			while (rs.next()) {
				m = new Detail ();
				m.setcid(rs.getString("cid"));
				m.setmid(rs.getString("mid"));
				m.setcuser(rs.getString("cuser"));
				m.setcomment(rs.getString("comment"));
				m.setctime(rs.getDate("ctime"));
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
