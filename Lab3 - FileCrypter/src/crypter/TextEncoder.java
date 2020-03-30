package crypter;

import java.util.ArrayList;

public class TextEncoder {
	private String text; 					// Store the input string
	private String encodedText = ""; 		// Store the encoded string
	private int key;						// Key used for encoding the string
	private ArrayList<Integer> cryptMethod = new ArrayList<>(); 
	private int lowerBound; 				// Lower bound of the alphabet used for encoding
	private int upperBound; 				// Upper bound of the alphabet used for encoding
	
	// Constructor
	public TextEncoder(int lowerBound, int upperBound, int key, String text) {
		// Set the variables
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;
		this.text = text;
		this.encodedText = text;
	}
	
	public void addMethod(int method) {
		cryptMethod.add(method);
	}
	
	public void generateEncodedText() {
		for(int method : cryptMethod) {
			if(method == 1) {
				String storeText = text;
				
				text = encodedText;
				encodedText = "";
				encodeByKey();
				text = storeText;
			}
			if(method == 2) {
				String storeText = text;
				text = encodedText;
				encodedText = "";
				encodeByShift();
				text = storeText;
			}
		}
	}
	
	// Function that computes the encoded string
	private void encodeByKey() {
		/* For each char in the string, add it
		 * to the encoded string using the key
		 */
		for (int iter = 0; iter < text.length(); iter++) {

			encodedText = encodedText + (char) (lowerBound + (text.charAt(iter) + key) % (upperBound - lowerBound));
		}
	}
	
	private void encodeByShift() {
		for(int iter = 0; iter < text.length(); iter++){
			encodedText = encodedText + (char) ((text.charAt(iter) + 1) % 255);
		}
	}
	
	// Getters
	public String getEncodedText() {
		return encodedText;
	}
	
	public String getText() {
		return text;
	}
	
	public int getKey() {
		return key;
	}
	
	public ArrayList<Integer> getEncodeMethods(){
		return cryptMethod;
	}
}
