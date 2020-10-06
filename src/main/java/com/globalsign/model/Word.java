package com.globalsign.model;

/**
 * 
 * @author Word
 * {@link Word}
 */

public class Word {
	private final char[] string;

	private final int length;

	public Word(char[] string) {
		this.length = string.length;
		this.string = string;
		lowercase();
	}

	public int length() {
		return length;
	}

	public char[] lowercase() {
		char ch;
		for (int i = 0; i < length; i++) {
			ch = string[i];
			if (ch >= 65 && ch <= 90)
				string[i] = (char) (97 + string[i] - 65);
		}
		return string;
	}

	public char charAt(int index) {
		if (index >= length)
			throw new ArrayIndexOutOfBoundsException();
		return string[index];
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Word))
			return false;
		Word charString = (Word) obj;
		if (charString.length() != length)
			return false;
		int i = 0, j = length - 1;
		while (i <= j) {
			if (this.charAt(i) != charString.charAt(i) || this.charAt(j) != charString.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	@Override
	public int hashCode() {
		if (string.length == 0)
			return -1;
		return string[0] - 97;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(char ch: string) {
			str.append(ch);
		}
		return str.toString();
	}
}
