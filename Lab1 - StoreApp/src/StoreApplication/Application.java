package StoreApplication;

import java.util.Scanner;
import java.util.Vector;

public class Application {

	public static void main(String[] args) {
		Store store = new Store();
		
		Employee employee1 = new Employee(store, "nume",true ,true);

		employee1.addProduct("RTX 2070", 2670, 5);
		employee1.addProduct("RTX 2080 Super", 3899, 4);
		employee1.addProduct("RTX 2080Ti", 6600, 2);

		
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
