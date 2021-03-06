package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Book;
import bean.User;
import util.DBUtil;

public class UserDao {
    public boolean create(User user) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="INSERT INTO tb_user VALUES(?,?,?,?)";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getAvatar());
			pstmt.setString(4, user.getGender());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
    public boolean updateUser(User user) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="UPDATE tb_user SET password=?,avatar=?,gender=? WHERE username=?";
		ResultSet rs = null;
		int result=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, user.getUsername());
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getAvatar());
			pstmt.setString(3, user.getGender());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
    public User query(String username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_user WHERE username=?";
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return user;
	}
}
