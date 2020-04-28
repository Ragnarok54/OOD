package application;

import java.util.ArrayList;

import interfaces.CompositeShape;

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
		// List of shapes that can be deleted + lambdas for actions
		ArrayList<IMenuItem> deleteMenuItems = new ArrayList<IMenuItem>();
		// List of shapes that can be modified + lambdas for actions
		ArrayList<IMenuItem> modifyMenuItems = new ArrayList<IMenuItem>();

		// Placeholders
		modifyMenuItems.add(new MenuItem("Circle", 1, null));
		modifyMenuItems.add(new MenuItem("Square", 2, null));
		deleteMenuItems.add(new MenuItem("Circle", 1, null));
		deleteMenuItems.add(new MenuItem("Square", 2, null));

		// Main menu
		mainMenuItems.add(new MenuItem("Add", 1, (parameters) -> {
			PluginManager pluginMan = new PluginManager();

			ApplicationMenu menu = new ApplicationMenu(pluginMan);
			menu.load(board);
			menu.execute();

		}));
		mainMenuItems.add(new Menu("Delete", 2, deleteMenuItems));
		mainMenuItems.add(new Menu("Modify", 3, modifyMenuItems));
		mainMenuItems.add(new MenuItem("View Board", 4, (parameters) -> {
			board.draw();
		}));

		return new Menu("Main Menu", 0, mainMenuItems);
	}

}
