package StoreApplication;

public class Stock {
	Product product;
	int amount;

	Stock(String name, int price, int amount) {
		product = new Product(name, price);
		this.amount = amount;
	}

	boolean available(int quantity) {
		if (amount >= quantity)
			return true;
		return false;
	}

	int amount() {
		return amount;
	}
	
	int getPrice() {
		return product.getPrice();
	}
	String getProductName() {
		return product.getProductName();
	}
	void updateStock(int quantity) {
		if (available(quantity))
			amount = amount - quantity;
	}
}
