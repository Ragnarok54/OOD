package parallelogramPlugin;

import java.util.Scanner;

import interfaces.IShape;

public class Parallelogram implements IShape {

	private int x1, y1; 
	private int x2, y2;
	private int diagonalLength;

	public void read() {
		Scanner consoleIn = new Scanner(System.in);

		System.out.println("Input coordinates for the first point: ");
		x1 = consoleIn.nextInt();
		y1 = consoleIn.nextInt();
		System.out.println("Input coordinates for the second point: ");
		x2 = consoleIn.nextInt();
		y2 = consoleIn.nextInt();
		System.out.println("Input diagonal size: ");
		diagonalLength = consoleIn.nextInt();
	}


	@Override
	public void draw() {
		System.out.println("Parallelogram: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", "
				+ y2 + ")" + " L: " + diagonalLength);
	}

	@Override
	public String get() {
		return "Parallelogram: P1(" + x1 + ", " + y1 + ") P2(" + x2 + ", " + y2 + ")" + " L: " + diagonalLength;
	}

	public String getShapeName() {
		return "Parralelogram";
	}
}