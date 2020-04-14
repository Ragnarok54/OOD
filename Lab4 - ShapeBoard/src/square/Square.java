package square;

import point.Point;
import shape.IShape;

public class Square implements IShape {

	private Point pDownRight;
	private Point pUpLeft;
	//private int x1,y1,x2,y2;
	public Square(Point p1, Point p2) {
		this.pUpLeft = p1;
		this.pDownRight = p2;
	}

	public Square(int x1, int y1, int x2, int y2) {
		this.pUpLeft = new Point(x1, y1);
		this.pDownRight = new Point(x2, y2);
		//this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
	}

	public void setUpP(int x, int y) {
		pUpLeft.setX(x); //this.x1 = x;
		pUpLeft.setY(y); //this.y1 = y;
	}

	public void setDownP(int x, int y) {
		pDownRight.setX(x); //this.x2 = x;
		pDownRight.setY(y); //this.y2 = y;
	}
	
	@Override
	public void draw() {
		System.out.println("Square: P1(" + pUpLeft.getX() + ", " + pUpLeft.getY() + 
				                  ") P2(" + pDownRight.getX() + ", " + pDownRight.getY() + ")");
	}
	
	@Override
	public String get() {
		return "Square: P1(" + pUpLeft.getX() + ", " + pUpLeft.getY() + 
                ") P2(" + pDownRight.getX() + ", " + pDownRight.getY() + ")";
	}
	
//	@Override
//	public void draw() {
//		System.out.println("Square: P1(" + x1 + ", " + y1 + 
//				                 ") P2(" + x2 + ", " + y1 + ")");
//	}
//	
//	@Override
//	public String get() {
//		return "Square: P1(" + x1 + ", " + y1 + 
//                ") P2(" + x2 + ", " + y2 + ")";
//	}
	
	public String getShapeName() {
		return "Square";
	}
}
