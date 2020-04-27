package application;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import circle.Circle;
import shape.CompositeShape;
import shape.IShape;
import square.Square;

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
		// List of shapes that can be added + lambdas for actions
		ArrayList<IMenuItem> addMenuItems = new ArrayList<IMenuItem>();
		// List of shapes that can be deleted + lambdas for actions
		ArrayList<IMenuItem> deleteMenuItems = new ArrayList<IMenuItem>();
		// List of shapes that can be modified + lambdas for actions
		ArrayList<IMenuItem> modifyMenuItems = new ArrayList<IMenuItem>();

		// Add circle to board
		addMenuItems.add(new MenuItem("Circle", 1, (parameters) -> {
			IShape x = new Circle();
			x.read();
			board.add(x);
			//createCircle(x1, y1, radius);
		}));
		// Add square to board
		addMenuItems.add(new MenuItem("Square", 2, (parameters) -> {
			IShape shape = new Square();
			shape.read();
			board.add(shape);
			//createSquare(x1, y1, x2, y2);
		}));

		// Delete circle from board
		deleteMenuItems.add(new MenuItem("Circle", 1, (parameters) -> {
			System.out.println(" ==== Shape to delete ====");
			IShape shape = new Circle();
			shape.read();
			removeShape(shape);
		}));
		// Delete square from board
		deleteMenuItems.add(new MenuItem("Square", 2, (parameters) -> {
			System.out.println(" ==== Shape to delete ====");
			IShape shape = new Square();
			shape.read();
			removeShape(shape);
		}));

		// Modify existing circle
		modifyMenuItems.add(new MenuItem("Circle", 1, (parameters) -> {
			// Search for the shape
			System.out.println(" ==== Shape to modify ====");
			IShape shape = new Circle();
			shape.read();
			int index = removeShape(shape);
			if (index >= 0) {
				// Get the modified values
				System.out.println(" ==== New values for circle ====");
				shape.read();
				board.addAtPos(shape, index);
			}else {
				System.out.println("Unable to find shape");
			}
		}));
		// Modify existing square
		modifyMenuItems.add(new MenuItem("Square", 2, (parameters) -> {
			// Search for the shape
			System.out.println(" ==== Shape to modify ====");
			IShape shape = new Square();
			shape.read();
			int index = removeShape(shape);
			if (index >= 0) {
				// Get the modified values
				System.out.println(" ==== New values for square ====");
				board.addAtPos(shape, index);
			}else {
				System.out.println("Unable to find shape");
			}
		}));

		// Main menu
		mainMenuItems.add(new Menu("Add", 1, addMenuItems));
		mainMenuItems.add(new Menu("Delete", 2, deleteMenuItems));
		mainMenuItems.add(new Menu("Modify", 3, modifyMenuItems));
		mainMenuItems.add(new MenuItem("View Board", 4, (parameters) -> {
			board.draw();
		}));

		return new Menu("Main Menu", 0, mainMenuItems);
	}


	private static int removeShape(IShape shape) {
		int it = -1;
		if (board.getSize() > 0) {
			for (it = 0; it < board.getSize(); it++) {
				if (board.atPos(it).get().equals(shape.get())) {
					board.atPos(it).draw();
					board.remove(it);
					return it;
				}
			}
		}
		return -1;
	}
}
