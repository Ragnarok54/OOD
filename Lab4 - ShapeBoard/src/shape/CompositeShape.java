package shape;

import java.util.ArrayList;

public class CompositeShape implements IShape {
	private final ArrayList<IShape> shapeList = new ArrayList<IShape>();

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
		else
		 if(index != -1)
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

	@Override
	public void draw() {
		int it = 0;
		if (shapeList.isEmpty()) {
			System.out.println("The board contains no shapes.");
		} else {
			System.out.println("///////////////////////////////////");
			System.out.println("Board contents are as follows:");
			for (IShape shape : shapeList) {
				System.out.print(++it + ". ");
				shape.draw();
			}
			System.out.println("///////////////////////////////////");
		}
	}

	@Override
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

}
