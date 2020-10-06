package com.globalsign.lib;

import com.globalsign.model.Item;

/**
 * 
 * @author Mehul Jain
 * 
 * This Class is processed the {@link HashTable} and inserted into {@link ItemSort} 
 *
 */

public class Frequency {
	private final HashTable hashTable;

	private final ItemsSort itemsSort;

	private int size;

	public Frequency(HashTable hashTable) {
		this.hashTable = hashTable;
		itemsSort = new ItemsSort();
		processHashTable();
	}

	private void processHashTable() {
		if(hashTable == null) return;
		Item[] items = hashTable.getAll();
		for (Item item : items) {
			itemsSort.insertItem(item);
		}
		size = itemsSort.getSize();
	}

	public Item getFrequency(int index) {
		if (index >= size)
			return null;
		return itemsSort.get(index);
	}

	public int getSize() {
		return size;
	}
}
