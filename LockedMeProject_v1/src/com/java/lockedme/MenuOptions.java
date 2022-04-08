package com.java.lockedme;

public class MenuOptions {

	
	public static void printWeocomeScreen(String applicationName, String developerName) {
		String applictionDeatils = String.format("-- Welcome to %s.com-- \n" + "--Application is developed by %s--.\n"
				+"----------------------------------\n",applicationName,developerName);
				
				
	    String appliactionFunction = "You can use this appliaction to :-\n"
	    		+"* Retrive all file names in the \"demo\" folder\n"
	    		+"* ADD Search, Delete files in \"demo\" folder\n"
	    		+"* Please provide the correct file name for delete and search\n";
	    
	    System.out.println(applictionDeatils);
	    
	    System.out.println(appliactionFunction);
	    
	}
	
	public static void displayMenu() {
		String menu = "\n-------Select option from below and press Enter------\n"
				+"1. Retrieve all files \"demo\" folder \n" 
				+" 2. Display menu for file features(Add,Search,Delete \n"
				+"3. Exit Program\n";
		System.out.println(menu);
	}
	
	public static void displayMenuOptions() {
		String fileMenuOptions = "\n Select any option from below and presss Enter\n"
			+"1. Add a file to \"demo\"folder\n"
			+"2. Delete a file from \"demo\" folder\n"
			+"3. Search a file \"demo\" folder \n"
			+"4. Show Prev. Menu\n"
			+"5. Exit Program\n";
		
		System.out.println(fileMenuOptions);
	}

}