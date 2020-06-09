package model;

import java.util.List;

public class MonAn {
	private int id;
	private String tenMon;
	private String moTa;
	private String anh;
	private int giaNiemYet;
	private String trangThai;
	private int luotXem;
	public String loai;


	public MonAn(String tenMon, String moTa, String anh, int giaNiemYet, String trangThai, int luotXem, String loai) {
		super();
		this.tenMon = tenMon;
		this.moTa = moTa;
		this.anh = anh;
		this.giaNiemYet = giaNiemYet;
		this.trangThai = trangThai;
		this.luotXem = luotXem;
		this.loai = loai;
	}
	
	public MonAn(int id, String tenMon, String moTa, String anh, int giaNiemYet, String trangThai, int luotXem,
			String loai) {
		super();
		this.id = id;
		this.tenMon = tenMon;
		this.moTa = moTa;
		this.anh = anh;
		this.giaNiemYet = giaNiemYet;
		this.trangThai = trangThai;
		this.luotXem = luotXem;
		this.loai = loai;
	}

	public MonAn() {
		// TODO Auto-generated constructor stub
	}

	public MonAn(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMon() {
		return tenMon;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		}
		final MonAn other = (MonAn) obj;
		if (other.getId() != this.getId()) {
			return false;
		}
		return true;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public int getGiaNiemYet() {
		return giaNiemYet;
	}

	public void setGiaNiemYet(int giaNiemYet) {
		this.giaNiemYet = giaNiemYet;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	
	
	
	public String getloai() {
		return loai;
	}

	public void setloai(String loai) {
		this.loai = loai;
	}

}
