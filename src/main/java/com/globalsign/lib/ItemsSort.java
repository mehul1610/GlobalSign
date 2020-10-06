package com.globalsign.lib;

import com.globalsign.model.Item;

/**
 * 
 * @author Mehul
 * 
 *         Gives the functionality of insert Item into sorting order according
 *         to Item frequency
 *
 */

public class ItemsSort {

	private Item[] items = new Item[20];

	private int size;

	public void insertItem(Item item) {
		if (size == 0) {
			items[size++] = item;
			return;
		}
		int position = getPosition(item);
		if (position == items.length)
			return;
		shiftItems(position, item);
	}

	private int getPosition(Item item) {
		for (int i = 0; i < size; i++) {
			if (items[i].getFrequency() < item.getFrequency())
				return i;
		}
		return size;
	}

	private void shiftItems(int i, Item item) {
		Item itemPrev = item, itemNext;
		for (; i < size; i++) {
			itemNext = items[i];
			items[i] = itemPrev;
			itemPrev = itemNext;
		}
		if (size == items.length)
			return;
		items[size++] = itemPrev;
	}

	public int getSize() {
		return size;
	}

	public Item get(int index) {
		return items[index];
	}

}
