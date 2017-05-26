package com.taylorb;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StegoHandler handler = new StegoHandler();
		
		boolean exit = false;
		while(!exit) {
			System.out.println("Steganography Menu");
			System.out.println("1 -> Encode");
			System.out.println("2 -> Decode");
			System.out.println("3 -> Exit");
			int option = scanner.nextInt();
			
			switch(option) {
				case 1:
					System.out.print("Enter Payload File Location: ");
					String payloadPath = scanner.next();
					System.out.print("Enter Image File Location: ");
					String imagePathForEncode = scanner.next();
					
					handler.encode(payloadPath, imagePathForEncode);
					
					break;
				case 2:
					System.out.print("Enter Image File Location: ");
					String imagePathForDecode = scanner.next();
					
					handler.decode(imagePathForDecode);
					
					break;
				case 3:
					exit = true;
					
					break;
				}
		}
		
		scanner.close();
	}
}