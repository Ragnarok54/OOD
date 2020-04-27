package square;

import point.Point;
import shape.IShape;

public class Square implements IShape {

	private Point pDownRight = new Point();
	private Point pUpLeft = new Point();


	public void read() {
		pDownRight.read();
		pUpLeft.read();
	}
	


	public void setUpP(int x, int y) {
		pUpLeft.setX(x); 
		pUpLeft.setY(y); 
	}

	public void setDownP(int x, int y) {
		pDownRight.setX(x); 
		pDownRight.setY(y); 
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

	
	public String getShapeName() {
		return "Square";
	}
}
