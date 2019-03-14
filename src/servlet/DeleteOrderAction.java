package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Order;
import bean.User;
import dao.BookDao;
import dao.OrderDao;
import dao.ShoppingDao;

/**
 * Servlet implementation class DeleteOrderAction
 */
@WebServlet("/DeleteOrderAction")
public class DeleteOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderAction() {
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
		PrintWriter out=response.getWriter();
		
		String orderid = request.getParameter("id");
		OrderDao orderdao=new OrderDao();
		if(orderdao.delete(Integer.parseInt(orderid)))
           out.println("<script>alert('删除成功.');location='order.jsp';</script>");
		else
		   out.println("<script>alert('删除失败.');location='javascript:history.go(-1)';</script>");
	       
        }
   

}

