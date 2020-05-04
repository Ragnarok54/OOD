package application;

import java.util.ArrayList;

public class Main {

	static CompositeShape board = new CompositeShape(); // list to save all the shapes on the board

	public static void main(String[] args) {

		System.out.println(" ==== Draw Shapes ====");
		Menu mainMenu = initializeMainMenu();
		mainMenu.execute();

	}

	// Init the menu lists
	private static Menu initializeMainMenu() {
		// List of starting menu items
		ArrayList<IMenuItem> mainMenuItems = new ArrayList<IMenuItem>();


		// Main menu
		mainMenuItems.add(new MenuItem("Add", 1, (parameters) -> {
			PluginManager pluginMan = new PluginManager();

			ApplicationMenu menu = new ApplicationMenu(pluginMan);
			menu.load(board);
			menu.execute();

		}));
		mainMenuItems.add(new MenuItem("Delete", 2, null));
		mainMenuItems.add(new MenuItem("Modify", 3, null));
		mainMenuItems.add(new MenuItem("View Board", 4, (parameters) -> {
			board.draw();
		}));

		return new Menu("Main Menu", 0, mainMenuItems);
	}

}
