package crypter;

import java.util.ArrayList;

public class TextDecoder {
	
	private String text = ""; 					
	private String encodedText; 				
	private int key;							// Key used for encoding the string
	private ArrayList<Integer> cryptMethod = new ArrayList<>(); 
	private int lowerBound; 					// Lower bound of the alphabet used for encoding
	private int upperBound; 					// Upper bound of the alphabet used for encoding

	public TextDecoder(int lowerBound, int upperBound, int key, String encodedText, ArrayList<Integer> cryptMethod) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;
		this.encodedText = encodedText;
		this.cryptMethod = cryptMethod;
		this.text = encodedText;
	}
	
	public void decode() {
		for(int method : cryptMethod) {
			if(method == 1) {
				String storeText = encodedText;
				encodedText = text;
				text = "";
				decodeByKey();
				encodedText = storeText;
			}
			if(method == 2){
				String storeText = encodedText;
				encodedText = text;
				text = "";
				decodeByShift();
				encodedText = storeText;
			}
		}
	}
	
	private void decodeByKey() {
		int currentChar;
		for (int iter = 0; iter < encodedText.length(); iter++) {
			
			currentChar = ((int) encodedText.charAt(iter) - key - lowerBound);
			while (currentChar < lowerBound) {
				currentChar = (currentChar + upperBound - lowerBound);
			}
			text = text + (char) currentChar;
		}
	}
	
	private void decodeByShift() {
		int currentChar;
		
		for(int iter = 0; iter < encodedText.length(); iter++) {
			currentChar = (int)( ( encodedText.charAt(iter) - 1) % 255);
			text = text + (char) currentChar;
		}
	}
	
	// Getters
	public String getText() {
		return text;
	}
	
	public String getEncodedText() {
		return encodedText;
	}
	
}
