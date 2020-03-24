package encoderApplication;

import java.util.Random;

public class Application {

	public static void main(String[] args) {
		int lowerBound = 0;
		int upperBound = 255;

		Random rand = new Random();
		
		int key = rand.nextInt(1000);
		
		Encoder encoder = new Encoder(lowerBound, upperBound, key);
		Decoder decoder = new Decoder(lowerBound, upperBound, key, encoder.getEncodedText());

		System.out.println("The original text is  " + encoder.getText());
		System.out.println("The coded text is     " + encoder.getEncodedText());
		System.out.println("The decoded text is   " + decoder.getText());

	}

}
