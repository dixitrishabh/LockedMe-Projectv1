package com.java.lockedme;

public class ProjectMain {
	
	public static void main(String[] args) {
		
		//Creating a demo if its is not there.
		FileFeatures.makeDemoFolder("demo");
		
		//Application Info.
		MenuOptions.printWelcomeScreen("LockedMe","Rishabh Dixit");
		
		ManageFeatures.manageWelcomeMessage();
	}

}
