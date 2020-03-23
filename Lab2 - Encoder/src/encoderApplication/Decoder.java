package encoderApplication;

public class Decoder {
	private String text = "";
	private String encodedText;
	private int key;
	private int lowerBound;
	private int upperBound;

	Decoder(Encoder x) {
		this.lowerBound = x.lowerBound;
		this.upperBound = x.upperBound;
		this.key = x.key;
		this.encodedText = x.encodedText;
		
		this.decode();
	}

	private void decode() {
		int currentChar;
		for (int i = 0; i < encodedText.length(); i++) {
			currentChar =  ((int)encodedText.charAt(i) - key - lowerBound);
		//	currentChar =  ((int)encodedText.charAt(i) + upperBound - key % upperBound);
			while(currentChar < 0) {
				currentChar =  (currentChar + upperBound - lowerBound);
			}
			text = text + (char)currentChar;
		}
	}
		
	public String getText() {
		return text;
	}

}
