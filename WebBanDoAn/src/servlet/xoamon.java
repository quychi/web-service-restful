package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import model.MonAn;

/**
 * Servlet implementation class xoamon
 */
public class xoamon extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpDelete deleteRequest = new HttpDelete(
			"http://localhost:8080/serviceWebFoods/restservices/monan/delete/idMonAn/" + id);

		HttpResponse r = httpClient.execute(deleteRequest);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("Xóa món ăn thành công ! <a href=\"admin.jsp"+""+"\">Trang chủ</a>");
		//sua xoa cx tuong tu, xoa la de nhat chi can goi url
	}

}
