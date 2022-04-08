package com.java.lockedme;

public class ProjectMain {
	
	public static void main(String[] args) {
		
		FileFeatures.makeDemoFolder("demo");
		
		MenuOptions.printWelcomeScreen("LockedMe","Rishabh Dixit");
		
		ManageFeatures.manageWelcomeMessage();
	}

}
