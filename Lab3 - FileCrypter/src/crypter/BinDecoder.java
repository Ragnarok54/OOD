package crypter;

import java.util.ArrayList;

public class BinDecoder {
	private String bin = ""; // Store the output string
	private String encodedBin; // Store the input string
	private int key; // Key used for encoding the string
	private ArrayList<Integer> cryptMethod = new ArrayList<>();
	private int lowerBound; // Lower bound of the alphabet used for encoding
	private int upperBound; // Upper bound of the alphabet used for encoding

	public BinDecoder(int lowerBound, int upperBound, int key, String encodedBin, ArrayList<Integer> cryptMethod) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;
		this.encodedBin = encodedBin;
		this.bin = encodedBin;
		this.cryptMethod = cryptMethod;
	}

	public void decode() {
		for (int method : cryptMethod) {
			String storeBin = encodedBin;

			encodedBin = bin;
			bin = "";
			if (method == 1) {
				decodeByKey();
			}
			if (method == 2) {
				decodeByShift();
			}
			encodedBin = storeBin;
		}
	}

	private void decodeByShift() {
		int currentChar;
		
		for(int iter = 0; iter < encodedBin.length(); iter++) {
			currentChar = (int)( ( encodedBin.charAt(iter) - 1) % 255);
			bin = bin + (char) currentChar;
		}
	}

	private void decodeByKey() {
		int currentChar;
		for (int iter = 0; iter < encodedBin.length(); iter++) {

			currentChar = ((int) encodedBin.charAt(iter) - key - lowerBound);
			while (currentChar < lowerBound) {
				currentChar = (currentChar + upperBound - lowerBound);
			}
			bin = bin + (char) currentChar;
		}
	}

	// Getters
	public String getDecodedBin() {
		return bin;
	}

	public String getEncodedBin() {
		return encodedBin;
	}

}
