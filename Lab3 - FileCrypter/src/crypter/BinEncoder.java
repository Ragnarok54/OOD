package crypter;

import java.util.ArrayList;

public class BinEncoder {
	private String bin; 					// Store the input string
	private String encodedBin = ""; 		// Store the encoded string
	private int key;						// Key used for encoding the string
	private ArrayList<Integer> cryptMethod = new ArrayList<>(); 
	private int lowerBound; 				// Lower bound of the alphabet used for encoding
	private int upperBound; 				// Upper bound of the alphabet used for encoding
	
	public BinEncoder(int lowerBound, int upperBound, int key, String bin) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.key = key;
		this.bin = bin;
		this.encodedBin = bin;
	}
	
	public void encode() {
		for(int method : cryptMethod) {
			String storeBin = bin;
			bin = encodedBin;
			encodedBin = "";
			
			if(method == 1) {
				encodeByKey();
			}
			if(method == 2) {
				encodeByShift();
			}
			bin = storeBin;
		}
	}
	
	public void addMethod(int method) {
		cryptMethod.add(method);
	}
	
	private void encodeByShift() {
		for(int iter = 0; iter < bin.length(); iter++){
			encodedBin = encodedBin + (char) ((bin.charAt(iter) + 1) % 255);
		}
	}
	
	private void encodeByKey() {
		/* For each bit in the string, add it
		 * to the encoded string using the key
		 */
		for (int iter = 0; iter < bin.length(); iter++) {

			encodedBin = encodedBin + (char) (lowerBound + (bin.charAt(iter) + key) % (upperBound - lowerBound));
		}
		
	}
	
	// Getters
	public String getBin() {
		return bin;
	}
	
	public String getEncodedBin() {
		return encodedBin;
	}
	
	public int getKey() {
		return key;
	}
	
	public ArrayList<Integer> getEncodeMethods(){
		return cryptMethod;
	}
}
