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
import bean.User;
import dao.BookDao;
import dao.CommentDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		int bookname = Integer.parseInt(request.getSession().getAttribute("BookName").toString());
		
		BookDao bookDao = new BookDao();
		Book book = new Book();
		if (type.equals("books")) {
			// 1 查询books
			List<Book> bookss = new ArrayList<Book>();
				book = bookDao.queryBook(bookname);
				bookss.add(book);
			
			
			// 2 查询图书头像
			Map<String, String> booksAvatar = getBookAvator(bookss);
			
			// 4 设置request.setAttribute
			request.setAttribute("bookss", bookss);
			request.setAttribute("booksAvatar", booksAvatar);
			
			// 5 请求包含include
			request.getRequestDispatcher("components/search-book.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected Map<String, String> getBookAvator(List<Book> books) {
		Map<String, String> map = new HashMap<String, String>();
		for (Book book:books) {
			if (book != null) {
				map.put(book.getBookname(), book.getAvatar());
			}
		}
		return map;
	}
}
