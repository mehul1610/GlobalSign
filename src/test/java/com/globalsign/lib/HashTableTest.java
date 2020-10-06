package com.globalsign.lib;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.globalsign.model.Node;
import com.globalsign.model.Word;

class HashTableTest {
	private HashTable table ;
	
	@BeforeEach
	public void init() {
		table = new HashTable();
		table.put(new Word(new char[] {'a', 'b', 'c'}));
		table.put(new Word(new char[] {'a', 'b', 'd'}));
		table.put(new Word(new char[] {'a', 'b', 'e'}));
	}
	
	@AfterEach
	public void destroy() {
		table = null;
	}
	
	
	@Test
	void testSize() {
		assertEquals(3, table.getSize());
		
		table.put(new Word(new char[] {'a', 'b', 'e'})); // same inserted not increase the size
		assertEquals(3, table.getSize());
		
		table.put(new Word(new char[] {'a', 'b', 'f'})); // diff inserted  increase the size
		assertEquals(4, table.getSize());
		
	}
	
	@Test
	void testGet() {
		assertNull(table.get(new Word(new char[] {'a'})));
		assertNotNull(table.get(new Word(new char[] {'a', 'b', 'c'})));
	}

}
