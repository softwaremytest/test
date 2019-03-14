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
import bean.Shopping;
import bean.User;
import dao.BookDao;
import dao.OrderDao;
import dao.ShoppingDao;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
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
		
		
		ShoppingDao shoppingDao = new ShoppingDao();
		if (type.equals("listshoppings")) {
			// 1 查询books
			List<Shopping> shoppings = null;
			if(username != null && !username.equals("")) {
				shoppings = shoppingDao.queryShoppingsByAuthor(username);
			} else {
				shoppings = shoppingDao.queryShoppings();
			}
			List<Book> books = new ArrayList<Book>();
			BookDao bookdao=new BookDao();
			for(int i=0;i<shoppings.size();i++)
				books.add(bookdao.queryBook(shoppings.get(i).getBookid()));
			// 2 查询图书头像
			Map<Integer, String> booksAvatar = getBookAvator(books);
			
			// 4 设置request.setAttribute
			request.setAttribute("shoppings", shoppings);
			request.setAttribute("booksAvatar", booksAvatar);
			
			// 5 请求包含include
			request.getRequestDispatcher("components/shop-book.jsp").include(request, response);
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
