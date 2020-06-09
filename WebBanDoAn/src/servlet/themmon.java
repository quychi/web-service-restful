package servlet;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.google.gson.Gson;

import control.MonAnCtr;
import model.MonAn;

/**
 * Servlet implementation class themmon
 */
public class themmon extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String tenmon = request.getParameter("tenmon");
		String mota = request.getParameter("mota");
		String anh = request.getParameter("anh");
		int gia = Integer.parseInt(request.getParameter("gia"));
		String trangthai = request.getParameter("trangthai");
		int luotxem = Integer.parseInt(request.getParameter("luotxem"));
		String loai = request.getParameter("loai");

		MonAn m = new MonAn(tenmon, mota, anh, gia, trangthai, luotxem, loai);

		Gson gson = new Gson();
		String jsonInString = gson.toJson(m);//chuyen obj MonAn thanh json de gui cho url khi them or sua
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(
			"http://localhost:8080/serviceWebFoods/restservices/monan/insert");

		StringEntity input = new StringEntity(jsonInString);
//		SysStem.out.println(jsonInString);
		input.setContentType("application/json");
		postRequest.setEntity(input);

		HttpResponse r = httpClient.execute(postRequest);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("Thêm món ăn thành công ! <a href=\"admin.jsp\">Trang chủ</a>");
		//sua xoa cx tuong tu, xoa la de nhat chi can goi url
	}

}
