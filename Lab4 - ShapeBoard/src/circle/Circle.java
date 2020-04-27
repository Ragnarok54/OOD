package circle;

import java.util.Scanner;

import point.Point;
import shape.IShape;

public class Circle implements IShape {
	
	private int radius;
	private Point origin = new Point();
	


	public void read() {
		((Point) origin).read();
		System.out.println("Input radius: ");
		Scanner consoleIn = new Scanner(System.in);
		radius = consoleIn.nextInt();
	}

	public int getX() {
		return (int) origin.getX();
	}

	public int getY() {
		return (int) origin.getY();
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle: P(" + (int) origin.getX() + ", " + (int) origin.getY() + ") R = " + radius);
	}

	@Override
	public String get() {
		return "Circle: P(" + (int) origin.getX() + ", " + (int) origin.getY() + ") R = " + radius;
	}
	
	public String getShapeName() {
		return "Circle";
	}
}