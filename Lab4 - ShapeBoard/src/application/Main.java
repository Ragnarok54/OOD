package application;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import circle.Circle;
import shape.CompositeShape;
import shape.IShape;
import square.Square;

public class Main {
	static int x1, x2, y1, y2, radius;
	static Point p1, p2;
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
			readCircle();
			createCircle(x1, y1, radius);
		}));
		// Add square to board
		addMenuItems.add(new MenuItem("Square", 2, (parameters) -> {
			readSquare();
			createSquare(x1, y1, x2, y2);
		}));

		// Delete circle from board
		deleteMenuItems.add(new MenuItem("Circle", 1, (parameters) -> {
			System.out.println(" ==== Shape to delete ====");
			readCircle();
			removeShape(new Circle(x1, y1, radius));
		}));
		// Delete square from board
		deleteMenuItems.add(new MenuItem("Square", 2, (parameters) -> {
			System.out.println(" ==== Shape to delete ====");
			readSquare();
			removeShape(new Square(x1, y1, x2, y2));
		}));

		// Modify existing circle
		modifyMenuItems.add(new MenuItem("Circle", 1, (parameters) -> {
			// Search for the shape
			System.out.println(" ==== Shape to modify ====");
			readCircle();
			int index = removeShape(new Circle(x1, y1, radius));
			if (index >= 0) {
				// Get the modified values
				System.out.println(" ==== New values for circle ====");
				readCircle();
				board.addAtPos(new Circle(x1, y1, radius), index);
			}
		}));
		// Modify existing square
		modifyMenuItems.add(new MenuItem("Square", 2, (parameters) -> {
			// Search for the shape
			System.out.println(" ==== Shape to modify ====");
			readSquare();
			int index = removeShape(new Square(x1, y1, x2, y2));
			if (index >= 0) {
				// Get the modified values
				System.out.println(" ==== New values for square ====");
				readSquare();
				board.addAtPos(new Square(x1, y1, x2, y2), index);
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

	// Read point into already existing variables based on option
	private static void readPoint(int option) {
		System.out.println("Input coordinates: ");
		Scanner consoleIn = new Scanner(System.in);
		if (option == 1) {
			x1 = consoleIn.nextInt();
			y1 = consoleIn.nextInt();
			p1 = new Point(x1, y1);
		} else {
			x2 = consoleIn.nextInt();
			y2 = consoleIn.nextInt();
			p2 = new Point(x2, y2);
		}
	}

	// Read radius into existing variable
	private static void readRadius() {
		System.out.println("Input radius: ");
		Scanner consoleIn = new Scanner(System.in);
		radius = consoleIn.nextInt();
	}

	private static void readSquare() {
		readPoint(1);
		readPoint(2);
	}

	private static void readCircle() {
		readPoint(1);
		readRadius();
	}

	// Pushback circle to the board
	private static void createCircle(int x, int y, int radius) {
		IShape z = new Circle(x, y, radius);
		board.add(z);
	}

	// Pushback square to the board
	private static void createSquare(int x1, int y1, int x2, int y2) {
		board.add(new Square(x1, y1, x2, y2));
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
