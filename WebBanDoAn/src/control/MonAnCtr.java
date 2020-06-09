package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mysql.jdbc.PreparedStatement;

import model.MonAn;
import model.MySQLConnectionUnit;

public class MonAnCtr implements MonAnDAO {

	public static ArrayList<MonAn> GetAllFoods() throws IOException{
		ArrayList<MonAn> listFoods = new ArrayList<MonAn>();
		MonAn mAn = null;

		URL urlForGetRequest = new URL("http://localhost:8080/serviceWebFoods/restservices/monan/search/all");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			// print result
//			System.out.println("JSON String Result " + response.toString());
// Start parsing
			String json = response.toString();
//			JSONObject jObj = new JSONObject(json.substring(json.indexOf('{')));
			Gson gson = new Gson();
			MonAn[] mangMonAn = gson.fromJson(json, MonAn[].class);
//test			
//			System.out.println(mangMonAn[0].getId());
//			System.out.println(mangMonAn[0].getAnh());

//chuyen mangMonAn vao list co kieu ArrayList<MonAn> de return ArrayList<MonAn>
			for (int i = 0; i < mangMonAn.length; i++) {
				mAn = new MonAn(); 			// phai = new ... de luu du lieu
				mAn.setId(mangMonAn[i].getId());
				mAn.setTenMon(mangMonAn[i].getTenMon());
				mAn.setMoTa(mangMonAn[i].getMoTa());
				mAn.setAnh(mangMonAn[i].getAnh());
				mAn.setGiaNiemYet(mangMonAn[i].getGiaNiemYet());
				mAn.setTrangThai(mangMonAn[i].getTrangThai());
				mAn.setLuotXem(mangMonAn[i].getLuotXem());
				mAn.setloai(mangMonAn[i].getloai());

				listFoods.add(mAn);
			}
		} else {
			System.out.println("GET NOT WORKED" + urlForGetRequest + " " + responseCode);
		}
		return listFoods;
	}
	
	
	@Override
	public MonAn getMonAn(int monAn) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		MonAn mAn = null;
		URL urlForGetRequest = new URL("http://localhost:8080/serviceWebFoods/restservices/monan/search/idMonAn/" + monAn);
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			// print result
//			System.out.println("JSON String Result " + response.toString());
// Start parsing
			String json = response.toString();
			JSONObject jObj = new JSONObject(json.substring(json.indexOf('{')));

//test
//			System.out.println(jObj.getInt("id"));
//			System.out.println(jObj.getString("tenMon"));
			
			mAn = new MonAn(); // phai = new ... de luu du lieu
			mAn.setId(jObj.getInt("id"));
			mAn.setTenMon(jObj.getString("tenMon"));
			mAn.setMoTa(jObj.getString("moTa"));
			mAn.setAnh(jObj.getString("anh"));
			mAn.setGiaNiemYet(jObj.getInt("giaNiemYet")); // jObj.getInt("giaNiemYet") ^^
			mAn.setTrangThai(jObj.getString("trangThai"));
			mAn.setLuotXem(jObj.getInt("luotXem") + 1);
			mAn.setloai(jObj.get("loai").toString());

		} else {
			System.out.println("GET NOT WORKED");
		}
		return mAn;
		
//cho comment duoi nay la doan no viet vs csdl mysql nen comment de day

//		String sql = "SELECT * FROM monan WHERE IdMonAn = ?";
//
//		Connection con = MySQLConnectionUnit.getMySQLConnection("localhost", "web", "root", "");
//		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
//		preparedStatement.setInt(1, monAn);
//
//		ResultSet rs = preparedStatement.executeQuery();
//		System.out.println(sql);
//		MonAn mAn = null;
//		while (rs.next()) {
//			mAn = new MonAn(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),
//					rs.getInt(7), rs.getString(8));
//		}
//		int luotxem = mAn.getLuotXem() + 1;
//		String sql2 = "UPDATE monan SET LuotXem = " + luotxem + " WHERE IdMonAn = " + monAn;
//		System.out.println(sql2);
//		PreparedStatement prs = (PreparedStatement) con.prepareStatement(sql2);
//		prs.executeUpdate();
//		return mAn;
	}

	@Override
	public ArrayList<MonAn> getListMonAn(String loai) throws ClassNotFoundException, SQLException, IOException {
		ArrayList<MonAn> list = new ArrayList<>();
		MonAn mAn = null;

		String urlForGetRequest = ("http://localhost:8080/serviceWebFoods/restservices/monan/search/loai/" + loai);
		String newurl = urlForGetRequest.replaceAll(" ", "%20"); // vi urlForGetRequest co chua dau cach nen phai
																	// encoded tuc replace " " bang %20
		URL urlEncodedURL = new URL(newurl);

		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlEncodedURL.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			// print result
//			System.out.println("JSON String Result " + response.toString());
// Start parsing
			String json = response.toString();
//			JSONObject jObj = new JSONObject(json.substring(json.indexOf('{')));
			Gson gson = new Gson();
			MonAn[] mangMonAn = gson.fromJson(json, MonAn[].class);
//test			
//			Sysem.out.println(mangMonAn[0].getAnh());

//chuyen mangMonAn vao list co kieu ArrayList<MonAn> de return ArrayList<MonAn>
			for (int i = 0; i < mangMonAn.length; i++) {
				mAn = new MonAn(); 			// phai = new ... de luu du lieu
				mAn.setId(mangMonAn[i].getId());
				mAn.setTenMon(mangMonAn[i].getTenMon());
				mAn.setMoTa(mangMonAn[i].getMoTa());
				mAn.setAnh(mangMonAn[i].getAnh());
				mAn.setGiaNiemYet(mangMonAn[i].getGiaNiemYet());
				mAn.setTrangThai(mangMonAn[i].getTrangThai());
				mAn.setLuotXem(mangMonAn[i].getLuotXem());
				mAn.setloai(mangMonAn[i].getloai());

				list.add(mAn);
			}
		} else {
			System.out.println("GET NOT WORKED" + urlForGetRequest + " " + responseCode);
		}
		return list;

//cho comment duoi nay la doan no viet vs csdl mysql nen comment de day
		
//		String sql = "SELECT * FROM monan WHERE Loai = ?";
//		Connection con = MySQLConnectionUnit.getMySQLConnection("localhost", "web", "root", "");
//
//		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
//		preparedStatement.setString(1, loai);
//		ResultSet rs = preparedStatement.executeQuery();
////		ArrayList<MonAn> list = new ArrayList<>();
//		while (rs.next()) {
//			MonAn mon = new MonAn(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),
//					rs.getInt(7), rs.getString(8));
//			mon.setId(rs.getInt(1));
//			list.add(mon);
//		}
//		return list;
	}

	@Override
	public List<MonAn> searchMon(String name) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM monan WHERE ";
		String[] words = name.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			if (i != words.length - 1) {
				sql += "TenMon LIKE '%" + words[i] + "%'";
				sql += " OR ";
			} else {
				sql += "TenMon LIKE +'%" + words[i] + "%'";
			}
		}
		Connection con = MySQLConnectionUnit.getMySQLConnection("localhost", "laptrinhweb", "root", "");
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		ArrayList<MonAn> list = new ArrayList<>();
		while (rs.next()) {
			MonAn mon = new MonAn(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),
					rs.getInt(7), rs.getString(8));
			mon.setId(rs.getInt(1));
			list.add(mon);
		}
		return list;
	}
//doan nay la ham main them vao khi test chay de fix bug
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		MonAnCtr m = new MonAnCtr();
		m.getListMonAn("Do uong");
//		MonAn mn= new MonAn();
//		System.out.println(mn.getId());
//		System.out.println(mn.getTenMon());
//		System.out.println(mn.getMoTa());
//		System.out.println(mn.getAnh());
//		System.out.println(mn.getGiaNiemYet());
//		System.out.println(mn.getTrangThai());
//		System.out.println(mn.getLuotXem());
//		System.out.println(mn.getloai());
	}
}
