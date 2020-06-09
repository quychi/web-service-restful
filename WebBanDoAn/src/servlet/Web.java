package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.CartCtr;
import model.Cart;
import model.MonAn;

@WebServlet("/add_to_cart")
public class Web extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("username") == null) {

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, resp);
		} else {
			if (request.getSession().getAttribute("cart") == null) {

				HashMap<MonAn, Integer> hash = new HashMap<>();
				Cart cart = new Cart(hash);
				CartCtr cartCtr = new CartCtr(cart);
				MonAn monAn = (MonAn) request.getSession().getAttribute("food");
				System.out.println(monAn.getTenMon());
				cartCtr.addToCart(monAn);
				request.getSession().setAttribute("cart", cart);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/giohang.jsp");
				requestDispatcher.forward(request, resp);

			} else {
				Cart cart = (Cart) request.getSession().getAttribute("cart");
				CartCtr cartCtr = new CartCtr(cart);
				MonAn monAn = (MonAn) request.getSession().getAttribute("food");
				cartCtr.addToCart(monAn);
				System.out.println(monAn.getGiaNiemYet() + monAn.getId());
				request.getSession().setAttribute("cart", cart);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/giohang.jsp");
				requestDispatcher.forward(request, resp);

			}
		}
	}
}
