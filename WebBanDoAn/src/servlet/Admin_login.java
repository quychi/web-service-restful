package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.ControllerUser;
import include.User;

/**
 * Servlet implementation class admin_login
 */
@WebServlet("/admin_login")
public class Admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_login() {
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
		response.setContentType("text/html;charset=UTF-8");	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		ControllerUser cuser = new ControllerUser();
		
		if(cuser.display(user)) {
			response.getWriter().println("Đăng nhập thành công !");
			response.sendRedirect("admin.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		}else {
			response.getWriter().println("Đăng nhập thất bại !");
		}
	}

}
