package rectanglePlugin;

import java.util.Scanner;

import interfaces.IShape;

public class Rectangle implements IShape {

	private int x1, y1; // The point to the left up side of the rectangle
	private int length;
	private int width;
	
	public void read() {
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input coordinates: ");
		x1 = consoleIn.nextInt();
		y1 = consoleIn.nextInt();
		System.out.println("Input length and width: ");
		length = consoleIn.nextInt();
		width = consoleIn.nextInt();
	}
	
	@Override
	public void draw() {
		System.out.println("Rectangle: P1(" + x1 + ", " + y1 + ") L: " + length + " W: " + width);
	}

	@Override
	public String get() {
		return "Rectangle: P1(" + x1 + ", " + y1 + ") L: " + length + " W: " + width;
	}

	public String getShapeName() {
		return "Rectangle";
	}
}