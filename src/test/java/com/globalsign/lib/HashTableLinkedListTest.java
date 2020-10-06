package com.globalsign.lib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.globalsign.model.Node;
import com.globalsign.model.Word;

class HashTableLinkedListTest {

	private HashTableLinkedList list ;
	private Node head;
	
	@BeforeEach
	public void init() {
		list = new HashTableLinkedList();
		list.insert(new Word(new char[] {'a', 'b', 'c'}));
		head = new Node(new Word(new char[] {'a', 'b', 'c'}));
		list.insert(new Word(new char[] {'a', 'b', 'd'}));
		list.insert(new Word(new char[] {'a', 'b', 'e'}));
	}
	
	@AfterEach
	public void destroy() {
		list = null;
	}
	
	@Test
	void testHead() {
		assertEquals(head.getWord(), list.getHead().getWord());
	}
	
	@Test
	void testFindWord() {
		assertEquals(null, list.findWord(new Word(new char[] {'a'})));
		assertNotNull(list.findWord(new Word(new char[] {'a', 'b', 'c'})));
	}
}
