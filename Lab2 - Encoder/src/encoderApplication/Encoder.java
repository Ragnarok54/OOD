package encoderApplication;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Encoder {
	private String text; // Store the input string
	protected String encodedText = ""; // Store the encoded string
	protected int key; // Key used for encoding the string
	protected int lowerBound; // Lower bound of the alphabet used for encoding
	protected int upperBound; // Upper bound of the alphabet used for encoding

	Encoder(int lowerBound, int upperBound, int key) {
		// Set the variables
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;

		// Read the input string from the file
		this.read();

		// Encode the string
		this.encode();

		// Output the string
		this.output();
	}

	public String getEncodedText() {
		return encodedText;
	}

	/* Function that reads the string
	 * to be encoded from the "input.txt"
	 * file
	 */
	private void read() {
		File input = new File("input.txt");

		try {
			Scanner sc = new Scanner(input);

			String str = sc.nextLine();
			text = str;
			// Print to console the input string
			System.out.println(text);

			sc.close();
		} catch (IOException e) {
			
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// Function that computes the encoded string
	private void encode() {
		/*
		 * For each char in the string, add it to the encoded string using the key
		 */
		for (int i = 0; i < text.length(); i++) {

			encodedText = encodedText + (char) (lowerBound + (text.charAt(i) + key) % (upperBound - lowerBound));
		}
	}

	/* Function used to output the encoded
	 * string to the "encoded.bin" file
	 */
	private void output() {
		try {
			File output = new File("encoded.bin");
			
			output.createNewFile();
	
		} catch (IOException e) {
			
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
