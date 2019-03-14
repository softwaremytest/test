package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

import bean.Book;
import bean.User;
import dao.BookDao;
import dao.UserDao;

import java.io.File;

/**
 * Servlet implementation class SignupAction
 */
@WebServlet("/BookSignupAction")
@MultipartConfig
public class BookSignupAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSignupAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("booksignup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		String bookname=request.getParameter("inputBookName");
		String bookauthor=request.getParameter("inputBookAuthor");
		String bookprice=request.getParameter("inputBookPrice");
		String introduce=request.getParameter("introduce");
		int booknum=Integer.parseInt(request.getParameter("inputBookNum"));
		Part part=request.getPart("avatar");
		
		String fileName=part.getSubmittedFileName();
		String newFileName=UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
		String filepath=getServletContext().getRealPath("./images/upload");
		File f=new File(filepath);
		if(!f.exists()) {
			f.mkdirs();
		}
		part.write(filepath+"/"+newFileName);
		String avatar=newFileName;
		
		Book book=new Book(bookname,bookauthor,bookprice,introduce,avatar,booknum);
		BookDao bookDao=new BookDao();
		boolean result=bookDao.create(book);
		if(result==true) {
			out.println("<script>alert('register successful.');location='booksignup.jsp';</script>");
		}else {
			out.println("<script>alert('register failed.');location='booksignup.jsp';</script>");
		}
	}

}
