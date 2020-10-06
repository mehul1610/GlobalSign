package com.globalsign.lib;

import com.globalsign.model.Node;
import com.globalsign.model.Word;

/**
 * 
 * @author Mehul
 * 
 * Gives the functionality of Linked list
 *
 */

public class HashTableLinkedList {

	private Node head;

	private Node tail;

	public void insert(Word word) {
		Node node = new Node(word);
		if (head == null) {
			head = node;
			tail = head;
			return;
		}
		tail.setNext(node);
		tail = node;
	}
	
	public Node findWord(Word word) {
		Node temp = head;
		while(temp !=null) {
			if(temp.getWord().equals(word))
				return temp;
			temp = temp.getNext();
		}
		return null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}	

}
