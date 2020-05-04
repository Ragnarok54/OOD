package trianglePlugin;

import java.util.Scanner;

import interfaces.IShape;

public class Triangle implements IShape {

	private int x1, y1;
	private int x2, y2;
	private int x3, y3; 

	public void read() {
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input coordinates for the first point: ");
		x1 = consoleIn.nextInt();
		y1 = consoleIn.nextInt();
		System.out.println("Input coordinates for the second point: ");
		x2 = consoleIn.nextInt();
		y2 = consoleIn.nextInt();
		System.out.println("Input coordinates for the third point: ");
		x3 = consoleIn.nextInt();
		y3 = consoleIn.nextInt();
	}

	@Override
	public void draw() {
		System.out.println("Triangle: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", "
				+ y2 + ") P3(" + x3 + ", " + y3 + ")");
	}

	@Override
	public String get() {
		return "Triangle: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", " + y2 + ") P3(" + x3 + ", " + y3 + ")";
	}

	public String getShapeName() {
		return "Triangle";
	}
}