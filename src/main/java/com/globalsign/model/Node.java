package com.globalsign.model;

/**
 * 
 * @author Mehul
 *
 *{@link Node}
 */
public class Node extends Item {
	private Node next;
	
	public Node(Word word) {
		super(word, 1);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
