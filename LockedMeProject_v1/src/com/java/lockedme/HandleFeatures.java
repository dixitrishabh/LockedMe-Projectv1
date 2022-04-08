package com.java.lockedme;

import java.util.Scanner;

public class HandleFeatures {
	
	public static void  handleWelcomeMessage()  {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				MenuOptions.displayMenu();
				int input = sc.nextInt();
				
				switch(input) {
				case 1:
					FileFeatures.displayAllFiles("demo");
					break;
				case 2:
					HandleFeatures.handleMenuOptions();
					break;
				case 3:
					System.out.println("Program exit successsully");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select the options that provided");
				}
			} catch(Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeMessage();
			}
		} while()
	}

}
