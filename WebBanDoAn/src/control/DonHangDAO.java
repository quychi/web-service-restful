package control;

import java.sql.SQLException;

import model.DonHang;

public interface DonHangDAO {
	public void insertDonHang(DonHang donHang, String tenTaiKhoanMua) throws ClassNotFoundException, SQLException;
}
