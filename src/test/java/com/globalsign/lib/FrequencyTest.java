package com.globalsign.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.globalsign.model.Item;
import com.globalsign.model.Word;

class FrequencyTest {
	
	private HashTable hashTable;

	private Frequency  frequency;
	@BeforeEach
	public void init() {
		hashTable = new HashTable();
		
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' }));
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' }));
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' }));
		
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' , 'd'}));
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' , 'd'}));
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' , 'd'}));
		hashTable.put(new Word(new char[] { 'a', 'b', 'c' , 'd'}));
		
		hashTable.put(new Word(new char[] { 'a', 'b', 'c', 'e'}));
		hashTable.put(new Word(new char[] { 'a', 'b', 'c', 'e'}));
		
		frequency = new Frequency(hashTable);
	}

	@AfterEach
	public void destroy() {
		hashTable = null;
		frequency = null;
	}
	
	@Test
	void testFrequency() {
		assertEquals(4, frequency.getFrequency(0).getFrequency());
		assertEquals(3, frequency.getFrequency(1).getFrequency());
	}
	
	@Test
	void testSize() {
		assertEquals(3, frequency.getSize());
	}

}
