package webservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.PreparedStatement;


import connection.MySQLConnectionUnit;
import model.MonAn;
import model.User;

@Path("user")
public class ModelUser {
	
	@GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> name() {
		ArrayList<User> listUser = new ArrayList<>();
		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM taikhoan";
			pst = (PreparedStatement) MySQLConnectionUnit.getMySQLConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("address"));
				listUser.add(u);
			}
			return listUser;		//nếu vứt dòng này ở dòng 48 thì lỗi 404
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				if(MySQLConnectionUnit.getMySQLConnection()  != null ) MySQLConnectionUnit.getMySQLConnection().close();
				if(pst  != null) pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}	
	
	
	@POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_JSON)			//tiêu thụ dtuong user (truyen tham so) dạng json
	@Produces(MediaType.APPLICATION_JSON)			//tạo ra 1 json chứa biến seccessful
	public String createUser(User u) throws SQLException{
		String s = "{\\\"success\\\":1}";
		String f = "{\\\"success\\\":0}";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO taikhoan(Username, Password, Name, Address, Email) VALUES(?, ?, ?, ?, ?)";
			pst = (PreparedStatement) MySQLConnectionUnit.getMySQLConnection().prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getName());
			pst.setString(5, u.getAddress());
			pst.setString(4, u.getEmail());
//			rs = pst.executeUpdate();
			pst.executeUpdate();
//			if(rs.absolute(1)) {
				return s;
//			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				if(MySQLConnectionUnit.getMySQLConnection()  != null ) MySQLConnectionUnit.getMySQLConnection().close();
				if(pst  != null) pst.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return f;
	}
	
	@POST
    @Path("authentication")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String authentication(User u) {
		String s = "{\\\"success\\\":1}";
		String f = "{\\\"success\\\":0}";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM taikhoan WHERE Username= ? AND Password= ?";
			pst = (PreparedStatement) MySQLConnectionUnit.getMySQLConnection().prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			rs = pst.executeQuery();
			if(rs.absolute(1)) {
				return s;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				if(MySQLConnectionUnit.getMySQLConnection()  != null ) MySQLConnectionUnit.getMySQLConnection().close();
				if(pst  != null) pst.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return f;//1 true 0 false
	}
	
	// hàm này nó viết hơi thừa, hay để hết account (admin vs thường) trong 1 bảng r dùng thêm 1 cột thuộc tính số nguyên 0,1 để xác định admin
	@POST
    @Path("authenticationAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String admin_login(User u) {			//truyền user (ko truyền username, pass) nó làm ktao 1 dtuong user vs username,pass đc nhập còn lai null 
		String s = "{\\\"success\\\":1}";
		String f = "{\\\"success\\\":0}";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM admin WHERE  username= ? AND password= ? ";
			pst = (PreparedStatement) MySQLConnectionUnit.getMySQLConnection().prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			rs = pst.executeQuery();
			if(rs.absolute(1)) {
				return s;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				if(MySQLConnectionUnit.getMySQLConnection()  != null ) MySQLConnectionUnit.getMySQLConnection().close();
				if(pst  != null) pst.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return f;//1 true, 0 false
	}
}