package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.User;
import util.DBUtil;

public class BookDao {
	public boolean create(Book book) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="INSERT INTO tb_book(bookname, bookauthor, bookprice,introduce,avatar,num,bv) VALUES(?,?,?,?,?,?,?)";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookname());
			pstmt.setString(2, book.getBookauthor());
			pstmt.setString(3, book.getBookprice());
			pstmt.setString(4, book.getIntroduce());
			pstmt.setString(5, book.getAvatar());
			pstmt.setInt(6, book.getNum());
			pstmt.setInt(7, book.getBv());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
	public boolean update(Book book) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="UPDATE tb_book SET bookname=?,bookauthor=?,"
				+ "bookprice=?,introduce=?,avatar=?,num=?,bv=? WHERE id=?";
		ResultSet rs = null;
		int result=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(8, book.getId());
			pstmt.setString(1, book.getBookname());
			pstmt.setString(2, book.getBookauthor());
			pstmt.setString(3, book.getBookprice());
			pstmt.setString(4, book.getIntroduce());
			pstmt.setString(5, book.getAvatar());
			pstmt.setInt(6, book.getNum()-1);
			pstmt.setInt(7, book.getBv());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
    public List<Book> queryBooks() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_book ";
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setBookauthor(rs.getString(3));
				book.setBookprice(rs.getString(4));
				book.setIntroduce(rs.getString(5));
				book.setAvatar(rs.getString(6));
				book.setNum(rs.getInt(7));
				book.setBv(rs.getInt(8));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return books;
	}
    public Book queryBook(int bookid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_book WHERE id=?";
		ResultSet rs = null;
		Book book = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book=new Book();
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setBookauthor(rs.getString(3));
				book.setBookprice(rs.getString(4));
				book.setIntroduce(rs.getString(5));
				book.setAvatar(rs.getString(6));
				book.setNum(rs.getInt(7));
				book.setBv(rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return book;
	}
	public List<Book> queryBooksByAuthor(String author) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_book WHERE bookauthor=? ";
		ResultSet rs = null;
		List<Book> books = new ArrayList<Book>();		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, author);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setBookauthor(rs.getString(3));
				book.setBookprice(rs.getString(4));
				book.setIntroduce(rs.getString(5));
				book.setAvatar(rs.getString(6));
				book.setNum(rs.getInt(7));
				book.setBv(rs.getInt(8));
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return books;
	}
	public Book queryBookByBookname(String bookname) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_book WHERE bookname=? ";
		ResultSet rs = null;
		Book book = null;		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setBookauthor(rs.getString(3));
				book.setBookprice(rs.getString(4));
				book.setIntroduce(rs.getString(5));
				book.setAvatar(rs.getString(6));
				book.setNum(rs.getInt(7));
				book.setBv(rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return book;
	}
	public Book queryBookById(int bookId) {
		Book book = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql1 = "UPDATE tb_book set bv=bv+1 WHERE id=?";
		String sql2 = "SELECT * FROM tb_book WHERE id=?";
		ResultSet rs = null;
		int result = 0;
		try {
			// 禁用自动提交
			conn.setAutoCommit(false); 
			
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
			if (result == 0) throw new Exception();
			pstmt.close();			
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setBookauthor(rs.getString(3));
				book.setBookprice(rs.getString(4));
				book.setIntroduce(rs.getString(5));
				book.setAvatar(rs.getString(6));
				book.setNum(rs.getInt(7));
				book.setBv(rs.getInt(8));
			}

			// 手动提交事务
			conn.commit(); 
		} catch (Exception e) {
			// 事务回滚 
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 启用自动提交
			try {
				conn.setAutoCommit(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return book;
	}
}
