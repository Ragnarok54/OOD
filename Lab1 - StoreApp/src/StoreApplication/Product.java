package StoreApplication;

public class Product {
	protected String name;
	protected int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	String getProductName() {
		return name;
	}
	
	int getPrice() {
		return price;
	}
}
