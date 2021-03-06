package encoderApplication;

public class Decoder {
	private String text = "";				// Store the input string
	private String encodedText;	 			// Store the encoded string
	private int key; 						// Key used for encoding the string
	private int lowerBound; 				// Lower bound of the alphabet used for encoding
	private int upperBound; 				// Upper bound of the alphabet used for encoding

	// Constructor
	Decoder(int lowerBound, int upperBound, int key, String encodedText) {
		// Set the variables
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;
		this.encodedText = encodedText;

		// Decode the string
		this.decode();
		}

	// Function used for computing the original string
	private void decode() {
		int currentChar;
		for (int iter = 0; iter < encodedText.length(); iter++) {
			
			currentChar = ((int) encodedText.charAt(iter) - key - lowerBound);
			while (currentChar < lowerBound) {
				currentChar = (currentChar + upperBound - lowerBound);
			}
			
			text = text + (char) currentChar;
		}
	}

	public String getText() {
		return text;
	}

}
