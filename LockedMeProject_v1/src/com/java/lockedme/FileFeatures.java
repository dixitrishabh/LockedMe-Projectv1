package com.java.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileFeatures {
	
	public static void makeDemoFolder(String folderName) {
		File file = new File(folderName);
		
		if(!file.exixts()) {
			file.mkdirs();
		}
	}
	
	public static void displayAllFiles(String path) {
		FileFeatures.makeDemoFolder("demo");
		
		List<String> filesNames = FileFeatures.listFilesInDirectory(path, 0, new ArrayList<String>());
	
		System.out.println("Dispaly all Files in ascending order");
		Collections.sort(filesNames);
		
		
		filesNames.stream().forEach(System.out::println);
	}
	
	
	public static List<String> listFilesInDirectory(String path, int indentationCount, List<String> filesNames){
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);
		
		Collections.sort(filesList);
		
		if(files != null && files.length > 0) {
			for(File file : filesList) {
				System.out.println(" ".repeat(indentationCount*2));
				
				if(file.isDirectory()) {
					System.out.println(" ---" + file.getName());
					
					filesNames.add(file.getName());
					listFilesInDirectory(file.getAbsolutePath(), indentationCount + 1, filesNames);
				}else {
					System.out.println("---" + file.getName());
					filesNames.add(file.getName());
				}
			}
			else {
				System.out.println(" ".repeat(indentationCount * 2));
				System.out.println("--- empty Dir");
			}
			
			System.out.println();
			return filesNames;
			
		}
		
	}
	

}
