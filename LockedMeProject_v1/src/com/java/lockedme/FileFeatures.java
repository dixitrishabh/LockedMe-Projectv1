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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileFeatures {
	
	public static void makeDemoFolder(String folderName) {
		File file = new File(folderName);
		
		if(!file.exists()) {
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
		}    else {
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
				Files.createFile(Filepath);
				System.out.println(AddFile + " created successfully ");
				
				System.out.println("Would you want add content in the file ? (Y/N)");
				String choice = sc.next().toLowerCase();
				
				sc.nextLine();
				
				if(choice.equals("y")) {
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
		
		public static List<String> displayLocationofFiles(String fileName, String path){
			List<String> filesName = new ArrayList<>();
			FileFeatures.searchaFile(path,fileName,filesName);
			
			if(filesName.isEmpty()) {
				System.out.println("\n Can not find the file with this name\n "+ fileName);
			}else {
				System.out.println("\n File found ");
				
				List<String> files = IntStream.range(0, filesName.size()).mapToObj(index -> (index +1) + 
						": " + filesName.get(index)).collect(Collectors.toList());
				
				files.forEach(System.out::println);
			}
		
			return filesName;
		
	}
		
		public static void searchaFile(String path,String fileName, List<String> filesName) {
			File dir = new File(path);
			File[] files = dir.listFiles();
			List<File> fileList = Arrays.asList(files);
			
			if(files != null && files.length > 0) {
				for(File file : fileList) {
					if(file.getName().startsWith(fileName)) {
						filesName.add(file.getAbsolutePath());
					}
					
					if(file.isDirectory()) {
						searchaFile(file.getAbsolutePath(),fileName,filesName);
					}
				}
			}
		}
	
		
		public static void deleteaFile(String path) {
			
			File currentFile = new File(path);
			File[] files = currentFile.listFiles();
			
			if(files != null && files.length > 0) {
				for (File file : files) {
					
					String fileName = file.getName() + " at " + file.getParent();
					if(file.isDirectory()) {
						deleteaFile(file.getAbsolutePath());
					}
					
					if(file.delete()) {
						System.out.println(fileName + " deleted successfully");
					}else {
						System.out.println("Failed to delete " + fileName);
					}
				}
			}
			
			String currentFileName = currentFile.getName() + " at " + currentFile.getParent();
			if(currentFile.delete()) {
				System.out.println(currentFileName + "deleted successfully");
			}else {
				System.out.println("Failed to delete " + currentFileName);
			}
		}
}
