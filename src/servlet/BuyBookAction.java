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
 * Servlet implementation class BuyBookAction
 */
@WebServlet("/BuyBookAction")
public class BuyBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyBookAction() {
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
		
		String bookid = request.getParameter("id");
		
		Book book=new Book();
		BookDao bookdao=new BookDao();
		book=bookdao.queryBook(Integer.parseInt(bookid));

        Order order=new Order();
		OrderDao orderdao=new OrderDao();
		//String username = ((User)request.getSession().getAttribute("User")).getUsername();
        if(request.getSession().getAttribute("User")==null)
        	out.println("<script>alert('请先登录.');location='signin.jsp';</script>");
         else{
        	String username = ((User)request.getSession().getAttribute("User")).getUsername();
        	order.setBookid(Integer.parseInt(bookid));
            order.setUsername(username);
            boolean c=orderdao.create(order);
		    if(book.getNum()<=0)
		    	out.println("<script>alert('余量不足，请等待管理员补货.');location='index.jsp';</script>");
		    
		    else{
		    	
		    	if(bookdao.update(book)&&c)
		    	{
		    		ShoppingDao shoppingdao=new ShoppingDao();
		    		shoppingdao.delete(Integer.parseInt(bookid), username);
		            out.println("<script>alert('购买成功.');location='index.jsp';</script>");
		    	}
		        else
		            out.println("<script>alert('购买失败.');location='javascript:history.go(-1)';</script>");
	        }
        }
     }

}
