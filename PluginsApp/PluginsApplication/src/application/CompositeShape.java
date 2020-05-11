package application;

import java.awt.Point;
import java.util.ArrayList;

import interfaces.IObserver;
import interfaces.IShape;
import shared.Boundary;

public class CompositeShape implements IObserver {
	private final ArrayList<IShape> shapeList = new ArrayList<IShape>();
	
	private final Point low = new Point(0, 0);
	private final Point high = new Point(0, 0);
	
	public void read() {
	}

	public void add(IShape shape) {
		shapeList.add(shape);
	}

	public void addAtPos(IShape shape, int index) {
		shapeList.add(index, shape);
	}

	public void remove(IShape shape) {
		shapeList.remove(shape);
	}

	public void remove(int index) {
		if (0 <= index && index < shapeList.size())
			shapeList.remove(index);
		else if (index != -1)
			throw new ArithmeticException("Index out of range");
		else
			System.out.println("Not found!");
	}

	public int find(IShape shape) {
		int it = 0;
		for (IShape s : shapeList) {
			if (s.get().equals(shape.get()))
				return it;
			it++;
		}
		return -1;
	}

	public int getSize() {
		return shapeList.size();
	}

	public IShape atPos(int pos) {
		int it = 0;
		for (IShape s : shapeList) {
			if (it == pos)
				return s;
			it++;
		}
		return null;
	}

	
	public void draw() {
		int it = 0;
		if (shapeList.isEmpty()) {
			System.out.println("The board contains no shapes.");
		} else {
			System.out.println("///////////////////////////////////");
			System.out.println("Board contents are as follows:");
			System.out.println("Boundaries: P1(" + (int)low.getX() + ", " + (int)low.getY() +") P2(" + (int)high.getX() + ", " + (int)high.getY() + ")");
			for (IShape shape : shapeList) {
				System.out.print(++it + ". ");
				shape.draw();
			}
			System.out.println("///////////////////////////////////");
		}
	}

	
	public String get() {
		int it = 0;
		String result = "";
		if (shapeList.isEmpty()) {
			result += "The board contains no shapes.";
		} else {
			result += "Board contents are as follows:\n";
			for (IShape shape : shapeList) {
				result += ++it + ". " + shape.get();
			}
		}

		return result;
	}

	@Override
	public void notification(Object x) {
		Boundary Rectangle = ((IShape)x).getBoundingRectangle();
		
		//System.out.println("------------Got:" + (Rectangle.getLow()).getX() + (Rectangle.getLow()).getY() +"else" + (Rectangle.getHigh()).getX() + " " +(Rectangle.getHigh()).getY() );
		
		// Lowest Point
		if((Rectangle.getLow()).getX() < low.getX())
			low.move((int)(Rectangle.getLow()).getX(),(int) low.getY());
		if((Rectangle.getLow()).getY() < low.getY())
			low.move((int)low.getX(), (int)(Rectangle.getLow()).getY());
		
		// Highest Point
		if((Rectangle.getHigh()).getX() > high.getX())
			high.move((int)(Rectangle.getHigh()).getX(), (int)high.getY());
		if((Rectangle.getHigh()).getY() > high.getY())
			high.move((int)high.getX(), (int) (Rectangle.getHigh()).getY());
			
	}

}
