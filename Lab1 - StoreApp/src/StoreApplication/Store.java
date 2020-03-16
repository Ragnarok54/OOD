package StoreApplication;

import java.util.*;

public class Store {

	Vector<Stock> stock = new Vector<>();
	int profit = 0;

	void addProduct(String name, int price, int amount) {
		int index = this.getIndex(name);

		if (index != -1 && stock.get(index).getPrice() == price) {
			stock.get(index).updateStock(-amount);  				// removes a negative value, means it adds stock to existing product
		} else {
			Stock product = new Stock(name, price, amount);
			stock.add(product);
		}
	}

	int getIndex(String name) {
		int index = 0;

		for (Stock product : stock) {
			if (product.getProductName() == name) {
				return index;
			}
			++index;
		}
		return -1;
	}

	void removeProduct(String name) {
		int index = this.getIndex(name);

		if (index != -1) {
			stock.remove(index);
		}
	}

	void sell(String name, int quantity) {
		int index = this.getIndex(name);

		if (stock.get(index).available(quantity)) {
			stock.get(index).updateStock(quantity);
			profit += stock.get(index).getPrice() * quantity;
		}
	}
	
	int getProfit() {
		return profit;
	}
}
