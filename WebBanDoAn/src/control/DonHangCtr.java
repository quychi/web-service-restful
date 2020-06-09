package control;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.DonHang;
import model.MonAn;
import model.MySQLConnectionUnit;

public class DonHangCtr implements DonHangDAO {

	@Override
	public void insertDonHang(DonHang donHang, String tenTKMua) throws ClassNotFoundException, SQLException {
		Connection con = MySQLConnectionUnit.getMySQLConnection("localhost", "laptrinhweb", "root", "");
		for (MonAn monAn : donHang.getList().keySet()) {
			System.out.println("đặt hàng");
			String sql = "INSERT INTO donhang(user, Id_monan, SDT, SoLuong, TongTien, HoTen, DiaChi, DateTime) VALUE(?, ?, ?, ?, ?, ?, ?, NOW())";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			preparedStatement.setString(1, tenTKMua);
			preparedStatement.setString(2, String.valueOf(monAn.getId()));
			preparedStatement.setString(3, donHang.getSdt());
			preparedStatement.setString(4, String.valueOf(donHang.getList().get(monAn)));
			preparedStatement.setString(5, String.valueOf(monAn.getGiaNiemYet() * donHang.getList().get(monAn)));
			preparedStatement.setString(6, donHang.getHoten());
			preparedStatement.setString(7, donHang.getAddress());
			preparedStatement.executeUpdate();
		}

	}

}
