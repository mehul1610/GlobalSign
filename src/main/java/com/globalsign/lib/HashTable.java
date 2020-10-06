package com.globalsign.lib;

import com.globalsign.model.Item;
import com.globalsign.model.Node;
import com.globalsign.model.Word;

/**
 * 
 * @author Mehul
 *
 *	maintain every word into bucket of {@link HashTableLinkedList}
 */
public class HashTable {
	private HashTableLinkedList[] bucket = new HashTableLinkedList[26];
	private int size;

	/**
	 * 
	 * @param word
	 * 
	 * put every word into {@link HashTableLinkedList} according to hashcode of first letter of word
	 */
	
	public void put(Word word) {
		if (word == null || word.length() == 0)
			return;
		int hashCode = word.hashCode();
		HashTableLinkedList list = bucket[hashCode];
		if (list == null) {
			list = new HashTableLinkedList();
			list.insert(word);
			bucket[hashCode] = list;
			++size;
		} else {
			Node node = list.findWord(word);
			if (node == null) {
				list.insert(word);
				++size;
			} else
				node.increaseFrequency();
		}

	}

	public Item get(Word word) {
		if (word == null || word.length() == 0)
			return null;
		int hashCode = word.hashCode();
		HashTableLinkedList list = bucket[hashCode];
		if (list == null)
			return null;
		return list.findWord(word);
	}

	public Item[] getAll() {
		Item[] items = new Item[size];
		HashTableLinkedList list = null;
		Node temp;
		int counter = 0;
		for (int i = 0; i < bucket.length; i++) {
			list = bucket[i];
			if (list == null)
				continue;
			temp = list.getHead();
			while (temp != null) {
				items[counter++] = temp;
				temp = temp.getNext();
			}
		}
		return items;
	}
	
	public int getSize() {
		return size;
	}
}
