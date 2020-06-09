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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		ControllerUser cuser = new ControllerUser();
		
		if(cuser.validate(user)) {
			if (username.equals("admin")) {
				response.getWriter().println("Đăng nhập thành công ! <a href=\"admin.jsp"+""+"\">Trang chủ</a>");
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
			} else {
				response.getWriter().println("Đăng nhập thành công ! <a href=\"index.jsp"+""+"\">Trang chủ</a>");
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
			}
		}else {
			
			response.getWriter().println("Đăng nhập thất bại !");
		}
	}

}
