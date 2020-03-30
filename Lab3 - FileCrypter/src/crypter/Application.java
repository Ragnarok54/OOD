package crypter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import utils.IO.InputFile;
import utils.IO.OutputFile;

public class Application {

	public static void main(String[] args) {
		Random rand = new Random();
		int key = rand.nextInt(1000); // Generate random key
		key = 243;
		
		System.out.println(
				"Choose the type of file you want to encode:\n1. Txt file\n2. Bin file\n3. Txt and Bin file\n");

		Scanner in = new Scanner(System.in);
		int input = in.nextInt();

		if(input == 1 || input == 3) {
			TextEncoder textEncoder;
			TextDecoder textDecoder;
			//Read text to be encoded
			InputFile txt = new InputFile();
			String inputText = txt.readLine("input.txt", 1);

			textEncoder = new TextEncoder(0, 255, key, inputText);

			System.out.println("Input how many times you want to encoode the text: ");
			int n = in.nextInt();
			System.out.println("Encode by:\n1. Random key\n2. Static Key");

			for (int it = 0; it < n; it++) {
				int choice = in.nextInt();
				textEncoder.addMethod(choice);
			}
			textEncoder.generateEncodedText();

			// Output the encoded text and the crypt methods
			OutputFile outTxt = new OutputFile();
			outTxt.write("output.txt", textEncoder.getEncodedText() + "\n", false);

			ArrayList<Integer> cryptMethodsTxt = textEncoder.getEncodeMethods();
			for (int method : cryptMethodsTxt) {
				outTxt.write("output.txt", method + " ", true);
			}
			cryptMethodsTxt.clear();

			// Read from the encoded file
			InputFile encodedTxt = new InputFile();
			String inputEnText = encodedTxt.readLine("output.txt", 1);
			String methods = encodedTxt.readLine("output.txt", 2);

			// Read the methods used for encoding
			for (int c = methods.length() - 1; c >= 0; c--) {
				if (methods.charAt(c) - '0' >= 0 && (int) methods.charAt(c) - '0' <= 9)
					cryptMethodsTxt.add((int) methods.charAt(c) - '0');
			}

			textDecoder = new TextDecoder(0, 255, key, inputEnText, cryptMethodsTxt);
			textDecoder.decode();

			System.out.println(textEncoder.getText());
			System.out.println(textDecoder.getEncodedText());
			System.out.println(textDecoder.getText());

		}

		if(input == 2 || input == 3){
			BinEncoder binEncoder;
			BinDecoder binDecoder;

			InputFile bin = new InputFile();
			String inputBin = bin.readLine("input.bin", 1);

			binEncoder = new BinEncoder(0, 255, key, inputBin);

			System.out.println("Input how many times you want to encoode the bin: ");
			int n = in.nextInt();
			System.out.println("Encode by:\n1. Random key\n2. Static Key");

			for (int i = 0; i < n; i++) {
				int choice = in.nextInt();
				binEncoder.addMethod(choice);
			}
			binEncoder.encode();

			// Output the encoded text and the crypt methods
			OutputFile outBin = new OutputFile();
			outBin.write("output.bin", binEncoder.getEncodedBin() + "\n", false);

			ArrayList<Integer> cryptMethodsBin = binEncoder.getEncodeMethods();
			for (int method : cryptMethodsBin) {
				outBin.write("output.bin", method + " ", true);
			}
			cryptMethodsBin.clear();

			// Read from the encoded file
			InputFile encodedBin = new InputFile();
			String inputEnBin = encodedBin.readLine("output.bin", 1);
			String methods = encodedBin.readLine("output.bin", 2);

			// Read the methods used for encoding
			for (int c = methods.length() - 1; c >= 0; c--) {
				if (methods.charAt(c) - '0' >= 0 && (int) methods.charAt(c) - '0' <= 9)
					cryptMethodsBin.add((int) methods.charAt(c) - '0');
			}
			binDecoder = new BinDecoder(0, 255, key, inputEnBin, cryptMethodsBin);
			binDecoder.decode();

			System.out.println(binEncoder.getBin());
			System.out.println(binDecoder.getEncodedBin());
			System.out.println(binDecoder.getDecodedBin());

		}
		in.close();
	}

}
