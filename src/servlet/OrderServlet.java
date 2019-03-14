package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Order;
import bean.User;
import dao.BookDao;
import dao.CommentDao;
import dao.OrderDao;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");	
		String username = ((User)request.getSession().getAttribute("User")).getUsername();
		
		
		OrderDao orderDao = new OrderDao();
		if (type.equals("listorders")) {
			// 1 查询books
			List<Order> orders = null;
			if(username != null && !username.equals("")) {
				orders = orderDao.queryOrdersByAuthor(username);
			} else {
				orders = orderDao.queryOrders();
			}
			List<Book> books = new ArrayList<Book>();
			BookDao bookdao=new BookDao();
			for(int i=0;i<orders.size();i++)
				books.add(bookdao.queryBook(orders.get(i).getBookid()));
			// 2 查询图书头像
			Map<Integer, String> booksAvatar = getBookAvator(books);
			
			// 4 设置request.setAttribute
			request.setAttribute("orders", orders);
			request.setAttribute("booksAvatar", booksAvatar);
			
			// 5 请求包含include
			request.getRequestDispatcher("components/order-book.jsp").include(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected Map<Integer, String> getBookAvator(List<Book> books) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Book book:books) {
			if (book != null) {
				map.put(book.getId(), book.getAvatar());
			}
		}
		return map;
	}
}
