package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import bean.Shopping;
import util.DBUtil;

public class ShoppingDao {
	public boolean create(Shopping shopping) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="INSERT INTO tb_shopping(bookid, username) VALUES(?,?)";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, shopping.getBookid());
			pstmt.setString(2, shopping.getUsername());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
	public boolean delete(int bookid,String username) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="DELETE FROM tb_shopping WHERE bookid=? AND username=?";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			pstmt.setString(2, username);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
	 public List<Shopping> queryShoppings() {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM tb_shopping ";
			ResultSet rs = null;
			List<Shopping> shoppings = new ArrayList<Shopping>();		
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Shopping shopping = new Shopping();
					shopping.setShopid(rs.getInt(1));
					shopping.setBookid(rs.getInt(2));
					shopping.setUsername(rs.getString(3));
					shopping.setShoptime(rs.getDate(4));
					
					shoppings.add(shopping);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeJDBC(null, pstmt, conn);
			}
			
			return shoppings;
		}
	public List<Shopping> queryShoppingsByAuthor(String username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_shopping WHERE username=? ";
		ResultSet rs = null;
		List<Shopping> shoppings = new ArrayList<Shopping>();		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Shopping shopping = new Shopping();
				shopping.setShopid(rs.getInt(1));
				shopping.setBookid(rs.getInt(2));
				shopping.setUsername(rs.getString(3));
				shopping.setShoptime(rs.getDate(4));
				shoppings.add(shopping);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return shoppings;
	}
}
