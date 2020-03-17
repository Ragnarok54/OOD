package StoreApplication;

public class Employee {
	String name;
	boolean canSell;
	boolean canManageStore;
	Store store;

	public boolean canManage() {
		return canManageStore;
	}

	public boolean canSell() {
		return canSell;
	}

	public Employee(Store store, String name, boolean canSell, boolean canManageStore) {
		this.store = store;
		this.name = name;
		this.canSell = canSell;
		this.canManageStore = canManageStore;
	}

	public void addProduct(String name, int price, int amount) {
		if (this.canManage()) {
			store.addProduct(name, price, amount);
		} else {
			System.out.println("Insufficient permisions");
		}
	}

	public void sellProduct(String name, int amount) {
		if (this.canSell()) {
			store.sell(name, amount);
		} else {
			System.out.println("Insufficient permisions");

		}
	}
	
	public void showStock() {
		store.showStock();
	}
}
