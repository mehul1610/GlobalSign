package com.globalsign.lib;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class FileProcessTest {
	
	@Test
	void testReadFile() {
		final FileProcess fileProcess = new FileProcess(null);
		assertThrows(NullPointerException.class, () -> {
			fileProcess.readFile();
		});
		
		final FileProcess fileProcess1 = new FileProcess(new File("InValidName"));
		assertThrows(FileNotFoundException.class, () -> {
			fileProcess1.readFile();
		});
	}

}
