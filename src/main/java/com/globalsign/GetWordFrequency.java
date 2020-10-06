package com.globalsign;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.globalsign.lib.FileProcess;
import com.globalsign.lib.Frequency;
import com.globalsign.model.Item;

public class GetWordFrequency {
	public static void main(String[] args) throws IOException {
		new GetWordFrequency().processFile("mobydick.txt");
	}
	
	public void processFile(String fileName) throws IOException {
		/**
		 * First do file process and insert every word into Hashtable 
		 * with the help of Linked list Implementation
		 */ 
		FileProcess process = new FileProcess(new File(fileName));
		try {
			process.readFile();
		} catch (FileNotFoundException e) {
			System.out.println(
					"File No Found in the location :: " + "Working Directory = " + System.getProperty("user.dir"));
			return;
		}
		
		/**
		 * If Table doesn't have any word than don't calculate the frequency
		 */ 
		if (process.getHashTable().getSize() == 0) {
			System.out.println("Not Found any word to process into file");
			return;
		}
		
		/**
		 * Process Hash table and linked list to get top 20 used word from the file 
		 */
		
		Frequency frequency = new Frequency(process.getHashTable());
		Item item = null;
		for (int i = 0; i < frequency.getSize(); i++) {
			item = frequency.getFrequency(i);
			System.out.println("Word ::" + item.getWord() + " : Frequency ::" + item.getFrequency());
		}
	}
}
