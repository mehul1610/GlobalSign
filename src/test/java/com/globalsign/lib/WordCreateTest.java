package com.globalsign.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCreateTest {

	private WordCreate wordCreate;
	
	@BeforeEach
	public void init() {
		wordCreate = new WordCreate();
		wordCreate.putChar('a');
		wordCreate.putChar('b');
		wordCreate.putChar('c');
	}
	
	@AfterEach
	public void destroy() {
		wordCreate = null;
	}
	
	@Test
	void testLength() {
		assertEquals(3, wordCreate.getSize());
	}
	
	@Test
	void testPutChar() {
		wordCreate.putChar('d');
		assertEquals(4, wordCreate.getSize());
	}

}
