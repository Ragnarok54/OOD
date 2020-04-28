package squarePlugin;

import java.util.Scanner;

import interfaces.IShape;

public class Square implements IShape {

	private int x1, y1; // The point to the left up side of the square
	private int x2, y2; // The point to the right down side of the square

	public void read() {
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
}
