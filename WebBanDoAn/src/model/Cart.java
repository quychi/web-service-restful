package model;

import java.util.HashMap;
import java.util.List;

import include.User;

public class Cart {
	private HashMap<MonAn, Integer> list;

	public Cart(HashMap<MonAn, Integer> list) {

		this.list = list;
	}

	public Cart() {

	}

	public HashMap<MonAn, Integer> getList() {
		return list;
	}

	public void setList(HashMap<MonAn, Integer> list) {
		this.list = list;
	}

}
