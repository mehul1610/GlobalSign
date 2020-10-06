package com.globalsign.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordTest {

	private Word word;
	private char[] array;
	
	{
		array = new char[] {'a', 'b', 'c'};
		word = new Word(new char[]{'a', 'b', 'C'});
	}
	
	@Test
	void testLength(){
		assertEquals(3, word.length());
	}
	
	@Test
	void testLowercase() {
		assertArrayEquals(array, word.lowercase());
	}
	
	@Test
	void testEquals() {
		assertTrue(word.equals(new Word(array)));
	}
	
	@Test
	void testHashCode() {
		assertEquals(0, word.hashCode());
	}
	
	@Test
	void test_toString() {
		assertEquals("abc", word.toString());
	}

}
