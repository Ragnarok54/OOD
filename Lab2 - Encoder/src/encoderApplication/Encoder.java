package encoderApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encoder {
	private String text; 					// Store the input string
	private String encodedText = ""; 		// Store the encoded string
	private int key; 						// Key used for encoding the string
	private int lowerBound; 				// Lower bound of the alphabet used for encoding
	private int upperBound; 				// Upper bound of the alphabet used for encoding

	// Constructor, it also outputs to file the result
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
	
	/* Function that reads the string to be
	 * encoded from the "input.txt" file
	 */
	private void read() {
		File input = new File("input.txt");

		try {
			Scanner sc = new Scanner(input);

			String str = sc.nextLine();
			text = str;

			sc.close();
		} catch (IOException e) {

			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// Function that computes the encoded string
	private void encode() {
		/* For each char in the string, add it
		 * to the encoded string using the key
		 */
		for (int iter = 0; iter < text.length(); iter++) {

			encodedText = encodedText + (char) (lowerBound + (text.charAt(iter) + key) % (upperBound - lowerBound));
		}
	}

	/* Function used to output the encoded
	 * string to the "encoded.bin" file
	 */
	private void output() {
		FileWriter output = null;
		try {
			File file = new File("encoded.bin");
			file.createNewFile();

			output = new FileWriter("encoded.bin");
			output.write(encodedText);

		} catch (IOException e) {

			System.out.println("An error occurred while creating file.");
			e.printStackTrace();
		}finally {
			try {
				output.close();
			}catch (IOException e) {
				System.out.println("An error occurred while closing file.");
				e.printStackTrace();
			}
		}
	}
	
	// Getters
	protected String getEncodedText() {
		return encodedText;
	}
	
	protected String getText() {
		return text;
	}
	
	protected int getKey() {
		return key;
	}

}
