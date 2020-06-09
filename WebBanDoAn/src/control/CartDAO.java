package control;

import java.util.HashMap;

import model.MonAn;

public interface CartDAO {
	public void addToCart(MonAn add);
	public void deleteFromCart(MonAn delete);
}
