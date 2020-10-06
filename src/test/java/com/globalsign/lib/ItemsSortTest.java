package com.globalsign.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.globalsign.model.Item;
import com.globalsign.model.Word;

class ItemsSortTest {

	private ItemsSort itemsSort;

	@BeforeEach
	public void init() {
		itemsSort = new ItemsSort();
		itemsSort.insertItem(new Item(new Word(new char[] { 'a', 'b', 'c' }), 3));
		itemsSort.insertItem(new Item(new Word(new char[] { 'a', 'b', 'c', 'd' }), 4));
		itemsSort.insertItem(new Item(new Word(new char[] { 'a', 'b', 'c', 'e' }), 2));
	}

	@AfterEach
	public void destroy() {
		itemsSort = null;
	}

	@Test
	void testSize() {
		assertEquals(3, itemsSort.getSize());
	}
	
	@Test
	void testIndex() {		
		assertEquals(4, itemsSort.get(0).getFrequency());
		itemsSort.insertItem(new Item(new Word(new char[] { 'a', 'b', 'c', 'e', 'e' }), 2));
		assertEquals(2, itemsSort.get(3).getFrequency());
	}

}
