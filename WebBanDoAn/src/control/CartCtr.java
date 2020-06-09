package control;

import java.util.HashMap;
import java.util.List;

import model.Cart;
import model.MonAn;

public class CartCtr implements CartDAO {
	Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartCtr(Cart cart) {
		super();
		this.cart = cart;
	}

	@Override
	public void addToCart(MonAn add) {
		// TODO Auto-generated method stub
		HashMap<MonAn, Integer> list = this.cart.getList();
		if (!list.containsKey(add)) {
			list.put(add, 1);
			this.cart.setList(list);
		} else {
			list.put(add, list.get(add) + 1);
			this.cart.setList(list);
		}
	}

	@Override
	public void deleteFromCart(MonAn delete) {
		// TODO Auto-generated method stub
		HashMap<MonAn, Integer> list = this.cart.getList();
		list.remove(delete);
		this.cart.setList(list);
	}

}
