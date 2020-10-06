package com.globalsign.lib;

import com.globalsign.model.Word;

/**
 * 
 * @author Mehul
 * Create Word from dynamic char array
 * 
 * By default array size is 10
 *
 */

public class WordCreate {
	private char[] charArray = new char[10];

	private int size = 0;

	public WordCreate() {
	}

	public void putChar(char ch) {
		if (size == charArray.length) {
			increaseSize();
		}
		charArray[size++] = ch;
	}

	private void increaseSize() {
		char[] copyCharArray = new char[charArray.length + 10];
		for (int i = 0; i < charArray.length; i++) {
			copyCharArray[i] = charArray[i];
		}
		charArray = copyCharArray;
	}

	public Word getWord() {
		char[] word = new char[size];
		for (int i = 0; i < size; i++) {
			word[i] = charArray[i];
		}
		return new Word(word);
	}
	
	public int getSize() {
		return size;
	}
}
