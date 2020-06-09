package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import model.MonAn;

/**
 * Servlet implementation class suamon
 */
public class suamon extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String tenmon = request.getParameter("tenmon");
		String mota = request.getParameter("mota");
		String anh = request.getParameter("anh");
		int gia = Integer.parseInt(request.getParameter("gia"));
		String trangthai = request.getParameter("trangthai");
		int luotxem = Integer.parseInt(request.getParameter("luotxem"));
		String loai = request.getParameter("loai");

		MonAn m = new MonAn(id, tenmon, mota, anh, gia, trangthai, luotxem, loai);

		Gson gson = new Gson();
		String jsonInString = gson.toJson(m);//chuyen obj MonAn thanh json de gui cho url khi them or sua
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPut putRequest = new HttpPut(
			"http://localhost:8080/serviceWebFoods/restservices/monan/put");

		StringEntity input = new StringEntity(jsonInString);
//		System.out.println(jsonInString);
		input.setContentType("application/json");
		putRequest.setEntity(input);

		HttpResponse r = httpClient.execute(putRequest);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("Sửa món ăn thành công ! <a href=\"admin.jsp"+""+"\">Trang chủ</a>");
		//sua xoa cx tuong tu, xoa la de nhat chi can goi url
	}

}
