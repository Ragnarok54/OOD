package circlePlugin;

import java.util.Scanner;

import interfaces.IShape;

public class Circle implements IShape {
	private int radius;
	private int x, y;

	public void read() {
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input coordinates: ");
		x = consoleIn.nextInt();
		y = consoleIn.nextInt();
		System.out.println("Input radius: ");
		radius = consoleIn.nextInt();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle: P(" + x + ", " + y + ") R = " + radius);
	}

	@Override
	public String get() {
		return "Circle: P(" + x + ", " + y + ") R = " + radius;
	}

	public String getShapeName() {
		return "Circle";
	}
}