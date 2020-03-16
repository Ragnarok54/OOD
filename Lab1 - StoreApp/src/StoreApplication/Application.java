package StoreApplication;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Store store = new Store();
		
		store.addProduct("RTX 2070", 2670, 5);
		store.addProduct("RTX 2080 Super", 3899, 4);
		store.addProduct("RTX 2080Ti", 6600, 2);

		
		System.out.println("Do you want to buy something? Here is what we have:");
		store.showStock();
		
		Scanner in = new Scanner(System.in);
		String item = in.nextLine();
		
		// TODO: improve the menu;
		store.sell(item, 1);
		store.showStock();
		
		
		
		in.close();
	}

}
