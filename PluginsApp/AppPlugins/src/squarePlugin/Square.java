package squarePlugin;

import java.awt.Point;
import java.util.Scanner;

import interfaces.IShape;
import shared.Boundary;
import shared.Observable;

public class Square extends Observable implements IShape {

	private int x1, y1; // The point to the left up side of the square
	private int x2, y2; // The point to the right down side of the square

	public void read() {
		@SuppressWarnings("resource")
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input coordinates: ");
		x1 = consoleIn.nextInt();
		y1 = consoleIn.nextInt();
		x2 = consoleIn.nextInt();
		y2 = consoleIn.nextInt();
	}

	public void setUpP(int x, int y) {
		x1 = x;
		y1 = y;
	}

	public void setDownP(int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void draw() {
		System.out.println("Square: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", "
				+ y2 + ")");
	}

	@Override
	public String get() {
		return "Square: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", "
				+ y2 + ")";
	}

	public String getShapeName() {
		return "Square";
	}

	@Override
	public Boundary getBoundingRectangle() {
		Point low = new Point(Math.min(x1,x2), Math.min(y1,y2));
		Point high = new Point(Math.max(x1,x2), Math.max(y1,y2));

		return new Boundary(low, high);
	}

}
