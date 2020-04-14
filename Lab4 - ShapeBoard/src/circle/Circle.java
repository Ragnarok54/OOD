package circle;

import java.awt.Point;

import shape.IShape;

public class Circle implements IShape {
	Point origin; // int x, y;
	int radius;

	public Circle(Point origin, int radius) {
		this.origin = origin;
		this.radius = radius;
	}

	public Circle(int x, int y, int radius) {
		this.origin = new Point(x, y); //this.x x = x;S this.y = y;
		this.radius = radius;
	}

	public int getX() {
		return (int) origin.getX(); //return x;
	}

	public int getY() {
		return (int) origin.getY(); //return y;
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
	
//	@Override
//	public void draw() {
//		System.out.println("Circle: P(" + x + ", " + y + ") R = " + radius);
//	}
//
//	@Override
//	public String get() {
//		return "Circle: P(" + x + ", " + y + ") R = " + radius;
//	}
}
