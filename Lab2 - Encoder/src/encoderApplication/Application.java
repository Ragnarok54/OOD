package encoderApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		int lowerBound = 0;
		int upperBound = 255;

		Random rand = new Random();

		int key = rand.nextInt(1000);

		// Read from file
		String text = null;
		File input = new File("input.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(input);

			String str = sc.nextLine();
			text = str;

		} catch (IOException e) {

			System.out.println("An error occurred while reading from file.");
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		Encoder encoder = new Encoder(lowerBound, upperBound, key, text);
		Decoder decoder = new Decoder(lowerBound, upperBound, key, encoder.getEncodedText());

		System.out.println("The original text is  " + encoder.getText());
		System.out.println("The coded text is     " + encoder.getEncodedText());
		System.out.println("The decoded text is   " + decoder.getText());

		// Output to file
		FileWriter output = null;
		try {
			File file = new File("encoded.bin");
			file.createNewFile();

			output = new FileWriter("encoded.bin");
			output.write(encoder.getEncodedText());

		} catch (IOException e) {

			System.out.println("An error occurred while creating file.");
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				System.out.println("An error occurred while closing file.");
				e.printStackTrace();
			}
		}

	}

}
