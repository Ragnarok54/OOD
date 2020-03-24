package encoderApplication;


public class Encoder {
	private String text; 					// Store the input string
	private String encodedText = ""; 		// Store the encoded string
	private int key; 						// Key used for encoding the string
	private int lowerBound; 				// Lower bound of the alphabet used for encoding
	private int upperBound; 				// Upper bound of the alphabet used for encoding
	
	// Constructor
	Encoder(int lowerBound, int upperBound, int key, String text) {
		// Set the variables
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;
		this.text = text;

		// Encode the string
		this.encode();
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
