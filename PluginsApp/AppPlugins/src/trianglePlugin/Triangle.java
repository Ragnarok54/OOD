package trianglePlugin;

import java.awt.Point;
import java.util.Scanner;

import interfaces.IShape;
import shared.Boundary;
import shared.Observable;

public class Triangle extends Observable implements IShape {

	private int x1, y1;
	private int x2, y2;
	private int x3, y3; 

	public void read() {
		@SuppressWarnings("resource")
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

	@Override
	public Boundary getBoundingRectangle() {
		Point low = new Point(Math.min(Math.min(x1, x2), x3), Math.min(Math.min(y1, y2), y3));
		Point high = new Point(Math.max(Math.max(x1, x2), x3), Math.max(Math.max(y1, y2), y3));

		return new Boundary(low, high);
	}

}