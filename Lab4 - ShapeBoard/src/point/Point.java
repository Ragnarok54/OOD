package point;

import shape.IShape;

public class Point implements IShape {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void draw() {
		System.out.println("P(" + x + ", " + y + ")");
	}

	@Override
	public String get() {
		return "P(" + x + ", " + y + ")";
	}

	public String getShapeName() {
		return "Point";
	}
}
