package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.DonHang;
import model.MonAn;

@WebServlet("/dathang")
public class DatHang extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tenTaikhoanMua = request.getParameter("usernameTaikhoanMua");
		String name = request.getParameter("name");
		String address = request.getParameter("xa") + ", " + request.getParameter("huyen") + ", "
				+ request.getParameter("thanhpho");
		String sdt = request.getParameter("sdt");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		HashMap<MonAn, Integer> hash = cart.getList();
		DonHang donHang = new DonHang(hash, address, sdt, name);
		DonHangCtr donHangCtr = new DonHangCtr();
//		System.out.println("Ä�áº·t hÃ ng");
		try {
			donHangCtr.insertDonHang(donHang,tenTaikhoanMua);
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter(); 
			out.println("alert('Đã lưu đơn hàng thành công!');");
			resp.sendRedirect("dathang.jsp");
//			request.getSession().removeAttribute("cart");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
