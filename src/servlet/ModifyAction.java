package servlet;

import java.io.File;
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

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class ModifyAction
 */
@WebServlet("/ModifyAction")
@MultipartConfig
public class ModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("modify.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		User user=(User)request.getSession().getAttribute("User");
	
		String password=request.getParameter("Password");
		String gender=request.getParameter("mgender");
		
		user.setPassword(password);
		user.setGender(gender);
		
		UserDao userDao=new UserDao();
		boolean result=userDao.updateUser(user);
		if(result) {
			out.println("<script>alert('modify successful.');location='signin.jsp';</script>");
		}else {
			out.println("<script>alert('modify failed.');location='modify.jsp';</script>");
		}
	}

}
