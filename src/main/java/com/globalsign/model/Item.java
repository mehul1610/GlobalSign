package com.globalsign.model;

/**
 * 
 * @author Mehul
 * 
 * {@link Item}
 *
 */

public class Item {
	protected int frequency;
	protected Word word;

	public Item(Word word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public void increaseFrequency() {
		++frequency;
	}
}
