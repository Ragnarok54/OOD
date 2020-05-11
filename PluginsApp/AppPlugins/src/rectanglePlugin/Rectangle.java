package rectanglePlugin;

import java.awt.Point;
import java.util.Scanner;

import interfaces.IShape;
import shared.Boundary;
import shared.Observable;

public class Rectangle extends Observable implements IShape {

	private int x1, y1; // The point to the left up side of the rectangle
	private int x2, y2;
	
	public void read() {
		@SuppressWarnings("resource")
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input first point: ");
		x1 = consoleIn.nextInt();
		y1 = consoleIn.nextInt();
		System.out.println("Input second point: ");
		x2 = consoleIn.nextInt();
		y2 = consoleIn.nextInt();
	}
	
	@Override
	public void draw() {
		System.out.println("Rectangle: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", " + y2 + " )" );
	}

	@Override
	public String get() {
		return "Rectangle: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", " + y2 + " )";
	}

	public String getShapeName() {
		return "Rectangle";
	}

	@Override
	public Boundary getBoundingRectangle() {
		Point low = new Point(Math.min(x1,x2), Math.min(y1,y2));
		Point high = new Point(Math.max(x1,x2), Math.max(y1,y2));

		return new Boundary(low, high);
	}

}