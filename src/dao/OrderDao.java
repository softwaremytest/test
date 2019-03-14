package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.Order;
import util.DBUtil;

public class OrderDao {
	public boolean create(Order order) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="INSERT INTO tb_order(bookid, username) VALUES(?,?)";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, order.getBookid());
			pstmt.setString(2, order.getUsername());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
	public boolean delete(int orderid) {
    	Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql="DELETE FROM tb_order WHERE orderid=? ";
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
    	return result==1;
    }
	public Order queryOrderByIDAndName(int bookid,String username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_order WHERE bookid=? AND username=? ";
		ResultSet rs = null;
		Order order =null;		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			pstmt.setString(2, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				order = new Order();
				order.setOrderid(rs.getInt(1));
				order.setBookid(rs.getInt(2));
				order.setUsername(rs.getString(3));
				order.setPurchtime(rs.getDate(4));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return order;
	}
	
	 public List<Order> queryOrders() {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM tb_order ";
			ResultSet rs = null;
			List<Order> orders = new ArrayList<Order>();		
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Order order = new Order();
					order.setOrderid(rs.getInt(1));
					order.setBookid(rs.getInt(2));
					order.setUsername(rs.getString(3));
					order.setPurchtime(rs.getDate(4));
					
					orders.add(order);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeJDBC(null, pstmt, conn);
			}
			
			return orders;
		}
	public List<Order> queryOrdersByAuthor(String username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tb_order WHERE username=? ";
		ResultSet rs = null;
		List<Order> orders = new ArrayList<Order>();		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt(1));
				order.setBookid(rs.getInt(2));
				order.setUsername(rs.getString(3));
				order.setPurchtime(rs.getDate(4));
				orders.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return orders;
	}
}
