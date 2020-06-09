package model;

import java.util.HashMap;

import model.MonAn;

public class DonHang {
	private HashMap<MonAn, Integer> list;
	private String address;
	private String sdt;
	private String hoten;

	public DonHang(HashMap<MonAn, Integer> list, String address, String sdt, String hoten) {
		super();
		this.list = list;
		this.address = address;
		this.sdt = sdt;
		this.hoten = hoten;
	}

	public HashMap<MonAn, Integer> getList() {
		return list;
	}

	public void setList(HashMap<MonAn, Integer> list) {
		this.list = list;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

}
