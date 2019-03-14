package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Comment;
import util.DBUtil;

public class CommentDao {
	public boolean create(Comment comment) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO comment(username, comment, bookid) VALUES(?,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getUsername());
			pstmt.setString(2, comment.getComment());
			pstmt.setInt(3, comment.getBookid());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return result==1;
	}
	public List<Comment> queryCommentsByBookId(int bookId) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM comment WHERE bookid=? ORDER BY comtime DESC";
		ResultSet rs = null;
		List<Comment> comments = new ArrayList<Comment>();		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setBookid(rs.getInt(2));
				comment.setUsername(rs.getString(3));
				comment.setComment(rs.getString(4));
				comment.setComtime(rs.getTimestamp(5));
				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return comments;
	}
}
