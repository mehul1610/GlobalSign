package com.globalsign.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
/**
 * 
 * @author Mehul Jain
 * 
 *  This Java class functionality of read character by character from file and process that character
 *
 */

public class FileProcess {
	private final HashTable hashTable;
	private File file;

	private boolean readNewWord;

	private WordCreate wordCreate;

	public FileProcess(File file) {
		hashTable = new HashTable();
		this.file = file;
	}

	private boolean isReadNewWord() {
		return readNewWord;
	}

	public void readFile() throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream(file);
		Reader reader = new BufferedReader(new InputStreamReader(in, Charset.defaultCharset()));
		int r;
		while ((r = reader.read()) != -1) {
			handleCharacter((char) r);
		}
		if (isReadNewWord()) { // end of line and end of last word if has
			handleCharacter(' ');
		}
	}
	
	/**
	 * 
	 * @param ch 
	 * 
	 * If character comes into A-Z and a-z than will process that one
	 *  Will create word from that one and put into hash table.
	 */

	private void handleCharacter(char ch) {
		if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
			if (wordCreate == null) {
				wordCreate = new WordCreate();
				readNewWord = true;
			}
			wordCreate.putChar(ch);
		} else {
			if (isReadNewWord()) {
				hashTable.put(wordCreate.getWord());
				wordCreate = null;
				readNewWord = false;
			}
		}
	}

	public HashTable getHashTable() {
		return hashTable;
	}

}
