package data.structures;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
	
	private ListNode last;
	private int length;
	
	public static class ListNode{
		public ListNode next;
		public int data;
		
		public ListNode( int data) {
			super();
			this.data = data;
		}
	}

	public CircularSinglyLinkedList() {
		super();
		this.last = null;
		this.length = 0;
	}
	
	public int length() {
		return length = 0;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void display() {
		ListNode firts = last.next;
		while (firts!=last) {
			System.out.print(firts.data +" -> ");
			firts = firts.next;
		}
		System.out.print(firts.data);
	}
	
	public void insertBegining(int data) {
		ListNode node = new ListNode(data);
		if (last == null) {
			last = node;
		}else {		
			node.next = last.next;
		}
		last.next = node;
		length++;
	}
	
	public void insertAtTheEnd(int data) {
		ListNode listNode = new ListNode(data);
		if (last == null) {
			last = listNode;
			last.next = last;
		}else {
			listNode.next = last.next;
			last.next = listNode;
			last = listNode;
		}
		length++;
	}
	
	public void deleteFirst() {
		ListNode first = last.next;
		last.next = first.next;
		first= first.next;
	}
	
	public void deleteLast() {
		ListNode temp = last;
		while (temp.next != last) {
			temp = temp.next;
		}
		temp.next = last.next;
		last=null;
		last=temp;
	}
	
	public void deletePosition(int index) {
		ListNode lastNode = last;
		ListNode firtNode = last.next;
		ListNode temp = firtNode;
		int count = 0;
		while (temp.next!=lastNode && count < index) {
			temp= temp.next;
			count++;
		}
		ListNode listNode = temp.next;
		temp.next = listNode.next;
		listNode.next= null;
		last = temp;
			
		length--;
		
	}
	
	public void insertAtPosition(int index,int data) {
		
	}
	
	public static void main(String[] args) {
		CircularSinglyLinkedList cir = new CircularSinglyLinkedList();
		cir.insertBegining(5);
		cir.insertBegining(4);
		cir.insertBegining(3);
		cir.insertBegining(2);
		cir.insertBegining(1);
		cir.display();
	}
	
}
