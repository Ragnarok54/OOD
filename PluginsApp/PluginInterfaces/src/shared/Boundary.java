package shared;

import java.awt.Point;

public class Boundary {

	private Point low; //lowest point
	private Point high; //lowest point

	public Boundary(Point low, Point high) {
		this.low = low;
		this.high = high;
	}
	
	public Point getLow() {
		return low;
	}
	
	public Point getHigh() {
		return high;
	}
	
}
