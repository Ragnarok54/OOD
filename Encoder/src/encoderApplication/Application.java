package encoderApplication;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Encoder encoder = new Encoder(0,255,1000);
		Decoder decoder = new Decoder(encoder);
		
		System.out.println(encoder.getEncodedText());
		
		System.out.println(decoder.getText());

	}

}
