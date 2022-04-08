package com.java.lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
		
		public static void creatingFile(String AddFile, Scanner sc) {
			FileFeatures.makeDemoFolder("demo");
			Path Filepath  = Paths.get("./demo/" + AddFile);
			
			try {
				Files.createDirectories(Filepath.getParent());
				File.creatingFile(Filepath);
				System.out.println(AddFile + "created successfully");
				
				System.out.println("Would you want add content in the file ? (Y/N)");
				String Choice = sc.next().toLowerCase();
				
				sc.nextLine();
				
				if(choice.equals("Y")) {
					System.out.println("\nInput content and Press enter\n");
					String content = sc.nextLine();
					Files.write(Filepath, content.getBytes());
					System.out.println("Wrritten content in file " + AddFile);
					System.out.println("Content can be read by Notepad");
				}
			} catch (IOException e) {
				System.out.println("File created failed" + AddFile);
				System.out.println(e.getClass().getName());
			
				
			}
		}
		
		
		
	}
	

}
