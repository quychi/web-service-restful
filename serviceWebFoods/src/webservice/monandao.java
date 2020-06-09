package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.MonAn;



@Path("monan")
public class monandao {
    private static List<MonAn> monanLoai;
	
	@GET
    @Path("search/loai/{loai}")
    @Produces(MediaType.APPLICATION_JSON)
    public MonAn[] searchByCategory(@PathParam("loai") String loai) throws Exception {
        monanLoai = GetFoods();		// ham GetFoods() o ngay duoi
        ArrayList monan = new ArrayList();
        for (MonAn m : monanLoai) {
            if (loai != null && loai.equalsIgnoreCase(m.getloai())) {
                monan.add(m);
            }
        }
        return (MonAn[]) monan.toArray(new MonAn[monan.size()]);
    }
	
	@GET
    @Path("search/all")
    @Produces(MediaType.APPLICATION_JSON)
	public static ArrayList<MonAn> GetFoods() throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			String host = "localhost";
			String dbName = "laptrinhweb";
			int port = 3306;
			String mysqlURL = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(mysqlURL, "root", "");
			String sql = "Select * from monan";
			stm = (PreparedStatement) con.prepareStatement(sql);

			rs = stm.executeQuery();
			ArrayList<MonAn> foodData = new ArrayList<MonAn>();

			while (rs.next()) {
				MonAn mon = new MonAn();
				mon.setId(rs.getInt("IdMonAn"));
				mon.setTenMon(rs.getString("TenMon"));
				mon.setMoTa(rs.getString("MoTa"));
				mon.setAnh(rs.getString("AnhMonAn"));
				mon.setGiaNiemYet(rs.getInt("GiaNemYet"));
				mon.setTrangThai(rs.getString("TrangThai"));
				mon.setLuotXem(rs.getInt("LuotXem"));
				mon.setloai(rs.getString("Loai"));
				foodData.add(mon);
			}
			return foodData;

		} catch (ClassNotFoundException ex) {
			System.out.println("error: " + ex);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return null;
	}

	@GET
    @Path("search/idMonAn/{idMonAn}")
    @Produces(MediaType.APPLICATION_JSON)
    public MonAn[] searchByCategory(@PathParam("idMonAn") int idfind) throws Exception {
        monanLoai = GetFoods();		// ham GetFoods() o ngay tren
        ArrayList monan = new ArrayList();
        for (MonAn m : monanLoai) {
            if (m.getId() == idfind) {
                monan.add(m);
            }
        }
        return (MonAn[]) monan.toArray(new MonAn[monan.size()]);
    }


	@POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insert(MonAn m) throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			String host = "localhost";
			String dbName = "laptrinhweb";
			int port = 3306;
			String mysqlURL = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(mysqlURL, "root", "");
			String sql = "INSERT INTO monan (TenMon, MoTa, AnhMonAn, GiaNemYet, TrangThai, LuotXem, Loai) VALUES (?, ?, ?, ?, ?, ?, ?)";
			stm = (PreparedStatement) con.prepareStatement(sql);

//			stm.setInt(1, 1000);			id tu tang trong mysql
			stm.setString(1, m.getTenMon());
			stm.setString(2, m.getMoTa());
			stm.setString(3, m.getAnh());
			stm.setInt(4, m.getGiaNiemYet());
			stm.setString(5, m.getTrangThai());
			stm.setInt(6, m.getLuotXem());
			stm.setString(7, m.getloai());

			stm.executeUpdate();

		} catch (ClassNotFoundException ex) {
			System.out.println("error: " + ex);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		}
    }

	@DELETE
    @Path("delete/idMonAn/{idMonAn}")
	public static void deleteFoods(@PathParam("idMonAn") String iddelete) throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			String host = "localhost";
			String dbName = "laptrinhweb";
			int port = 3306;
			String mysqlURL = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(mysqlURL, "root", "");

			String sql = "SET FOREIGN_KEY_CHECKS=0;";
			stm = (PreparedStatement) con.prepareStatement(sql);
			stm.executeUpdate();

//			String iddelete = "1003"; // gan id mon muon xoa
			sql = "DELETE FROM monan WHERE IdMonAn = '" + iddelete + "'";
			stm = (PreparedStatement) con.prepareStatement(sql);
			stm.executeUpdate();

			sql = "SET FOREIGN_KEY_CHECKS=1;";
			stm = (PreparedStatement) con.prepareStatement(sql);
			stm.executeUpdate();

		} catch (ClassNotFoundException ex) {
			System.out.println("error: " + ex);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
	
	@PUT
    @Path("put")
	public static void updateFoods(MonAn m) throws SQLException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			String host = "localhost";
			String dbName = "laptrinhweb";
			int port = 3306;
			String mysqlURL = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(mysqlURL, "root", "");

			String sql = "SET FOREIGN_KEY_CHECKS=0;";
			stm = (PreparedStatement) con.prepareStatement(sql);
			stm.executeUpdate();

			int idput = m.getId(); // gan id mon muon update
			sql = "update monan set TenMon = ?, MoTa = ?, AnhMonAn = ?, GiaNemYet = ?, TrangThai = ?, LuotXem = ?, Loai = ? where IdMonAn = " + idput;
			stm = (PreparedStatement) con.prepareStatement(sql); // tai sao prepareStatement nay de sau khi set ? lai
																	// chay out of range???
			
			stm.setString(1, m.getTenMon());
			stm.setString(2, m.getMoTa());
			stm.setString(3, m.getAnh());
			stm.setFloat(4, m.getGiaNiemYet());
			stm.setString(5, m.getTrangThai());
			stm.setInt(6, m.getLuotXem());
			stm.setString(7, m.getloai());
			stm.executeUpdate();

			sql = "SET FOREIGN_KEY_CHECKS=1;";
			stm = (PreparedStatement) con.prepareStatement(sql);
			stm.executeUpdate();

		} catch (ClassNotFoundException ex) {
			System.out.println("error: " + ex);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

//	public static void main(String[] args) throws Exception {
//		try {
////			for (MonAn m :GetFoods()) {
////				System.out.println(m.getIdMonAn());
////				System.out.println(m.getTenMon());
////				System.out.println(m.getAnhMonAn());
////				System.out.println(m.getMoTa());
////				System.out.println(m.getGiaNemYet());
////				System.out.println(m.getTrangThai());
////				System.out.println(m.getLuotXem());
////				System.out.println(m.getLoai());
////			};
//			monanLoai = GetFoods();
//			String loai="Com";
//	        ArrayList monan = new ArrayList();
//
//			for (MonAn m : monanLoai) {
//	            if (loai != null && loai.equalsIgnoreCase(m.getLoai())) {
//	                monan.add(m);
//	            }
//	        }
//	        MonAn[] kq = (MonAn[]) monan.toArray(new MonAn[monan.size()]);
//	        for (int i = 0; i < kq.length; i++) {
//				
//				System.out.println(kq[i].getIdMonAn());
//				System.out.println(kq[i].getTenMon());
//				System.out.println(kq[i].getAnhMonAn());
//				System.out.println(kq[i].getMoTa());
//				System.out.println(kq[i].getGiaNemYet());
//				System.out.println(kq[i].getTrangThai());
//				System.out.println(kq[i].getLuotXem());
//				System.out.println(kq[i].getLoai());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
