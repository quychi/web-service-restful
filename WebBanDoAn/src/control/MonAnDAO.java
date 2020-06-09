package control;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import model.MonAn;

public interface MonAnDAO {
	public MonAn getMonAn(int monAn) throws ClassNotFoundException, SQLException, IOException;
	public List<MonAn> searchMon(String name) throws ClassNotFoundException, SQLException;
	public List<MonAn> getListMonAn(String loai) throws ClassNotFoundException, SQLException, IOException;
}
