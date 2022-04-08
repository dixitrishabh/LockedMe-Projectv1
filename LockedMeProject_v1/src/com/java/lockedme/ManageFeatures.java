package com.java.lockedme;

import java.util.List;
import java.util.Scanner;

public class ManageFeatures {
	
	public static void  manageWelcomeMessage()  {
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
					ManageFeatures.manageMenuOptions();
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
				manageWelcomeMessage();
			}
		} while(running == true);
	}
	
	
	public static void manageMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try { 
				MenuOptions.displayMenu();
				FileFeatures.makeDemoFolder("demo");
				
				int input = sc.nextInt();
				
				switch(input) {
				case 1:
					System.out.println("Enter the name of file which you have to add \"demo\" folder");
					String AddFile = sc.next();
					
					FileFeatures.creatingFile(AddFile, sc);
					
					break;
				case 2:
					
					System.out.print("Enter the name of file that you have to delete \"demo\" folder");
					String deleteFile = sc.next();
					
					FileFeatures.makeDemoFolder("demo");
					List<String> deleteFiles = FileFeatures.displayLocationofFiles(deleteFile, "demo");
					
					String deletePrompt = " \nSelect the index of which file to delete ?" + "\n(Enter 0 if you want to delete all)";
					
					System.out.println(deletePrompt);
					
					
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileFeatures.deleteaFile(deleteFiles.get(idx -1));
					}else {
						for(String path : deleteFiles) {
							FileFeatures.deleteaFile(path);
						}
					}
					
					
					break;
					
					
				case 3:
					System.out.println("Enter the File that you have to search \"main\" folder ");
					String fileName = sc.next();
					
					FileFeatures.makeDemoFolder("demo");
					FileFeatures.displayLocationofFiles(fileName, "demo");
					
					break;
					
				case 4:
					return ;
					
				case 5:
					
					System.out.println("Program exit successfully");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select the option that is provided");
					
				}
				
			}catch(Exception e) {
				System.out.println(e.getClass().getName());
				manageMenuOptions();
			}
		}
		
		while(running == true);
	}
}