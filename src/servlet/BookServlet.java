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
import bean.Comment;
import bean.User;
import dao.BookDao;
import dao.CommentDao;
import dao.UserDao;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		String bookId = request.getParameter("id");
		String author = request.getParameter("author");
		
		BookDao bookDao = new BookDao();
		CommentDao commentDao = new CommentDao();
		if (type.equals("listbooks")) {
			// 1 查询books
			List<Book> books = null;
			if(author != null && !author.equals("")) {
				books = bookDao.queryBooksByAuthor(author);
			} else {
				books = bookDao.queryBooks();
			}
			
			// 2 查询图书头像
			Map<String, String> booksAvatar = getBookAvator(books);
			
			// 4 设置request.setAttribute
			request.setAttribute("books", books);
			request.setAttribute("booksAvatar", booksAvatar);
			
			// 5 请求包含include
			request.getRequestDispatcher("components/index-book.jsp").include(request, response);
		} else if (type.equals("listbook")) {
			if (bookId != null && !bookId.equals("")) {
				// 1 查询post
				Book book = bookDao.queryBookById(Integer.parseInt(bookId));
				
				// 2 查询评论数量
				List<Book> books = new ArrayList<Book>();
				books.add(book);
				// 查询图书头像
				Map<Integer, Integer> booksCommentsCount = getBooksCommentsCount(books);
				Map<String, String> booksAvatar = getBookAvator(books);
				
				
				// 3 设置request.setAttribute
				request.setAttribute("book", book);
				request.setAttribute("booksAvatar", booksAvatar);
				request.setAttribute("booksCommentsCount", booksCommentsCount);
				// 4 请求包含include
				request.getRequestDispatcher("components/book-content.jsp").include(request, response);
			}
		} else if (type.equals("listcomments")) {
			if (bookId != null && !bookId.equals("")) {
				// 1 查询comments
				List<Comment> comments = commentDao.queryCommentsByBookId(Integer.parseInt(bookId));
				// 2 查询comment的作者头像
				Map<Integer, String> commentsAuthorAvatar = getCommentAuthorAvator(comments);
				// 3 设置request.setAttribute
				request.setAttribute("comments", comments);
				request.setAttribute("commentsAuthorAvatar", commentsAuthorAvatar);
				// 4 请求包含include
				request.getRequestDispatcher("components/book-comments.jsp").include(request, response);
			}
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
	
	protected Map<Integer, Integer> getBooksCommentsCount(List<Book> books) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		CommentDao commentDao = new CommentDao();
		for (Book book:books) {
			List<Comment> comments = commentDao.queryCommentsByBookId(book.getId());
			map.put(book.getId(), comments.size());
		}
		return map;
	}
	
	protected Map<Integer, String> getCommentAuthorAvator(List<Comment> comments) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		UserDao userDao = new UserDao();
		for (Comment comment:comments) {
			User user = userDao.query(comment.getUsername());
			if (user != null) {
				map.put(comment.getId(), user.getAvatar());
			}
		}
		return map;
	}
}
  