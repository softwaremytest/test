package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
import bean.Order;
import bean.User;
import dao.CommentDao;
import dao.OrderDao;

/**
 * Servlet implementation class NewCommentAction
 */
@WebServlet("/NewCommentAction")
public class NewCommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCommentAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String content = request.getParameter("comment");
		String bookId = request.getParameter("id");
		String username = ((User)request.getSession().getAttribute("User")).getUsername();
		
		OrderDao orderdao=new OrderDao();
		Order order=orderdao.queryOrderByIDAndName(Integer.parseInt(bookId), username);
		
		Comment comment = new Comment();
		comment.setComment(content);
		comment.setUsername(username);
		comment.setBookid(Integer.parseInt(bookId));
		CommentDao commentDao = new CommentDao();
		boolean result = commentDao.create(comment);
		if(order!=null) {
		   if (result == true) {
			   out.println("<script>alert('new comment successfully.');location='index.jsp';</script>");
		   } else {
			   out.println("<script>alert('new comment failed.');location='javascript:history.go(-1)';</script>");
		   }
		}
		else {
			out.println("<script>alert('还未购买该书籍，请先购买.');location='javascript:history.go(-1)';</script>");
		}
	}

}
