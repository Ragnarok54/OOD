package circlePlugin;

import java.awt.Point;
import java.util.Scanner;

import interfaces.IShape;
import shared.Boundary;
import shared.Observable;

public class Circle extends Observable implements IShape {
	private int radius;
	private int x, y;

	public void read() {
		@SuppressWarnings("resource")
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input coordinates: ");
		x = consoleIn.nextInt();
		y = consoleIn.nextInt();
		System.out.println("Input radius: ");
		radius = consoleIn.nextInt();
		//this.registerObserver(board);
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

	@Override
	public Boundary getBoundingRectangle() {
		Point max = new Point(x + radius, y + radius);
		Point min = new Point(x - radius, y - radius);

		return new Boundary(min, max);
	}

}