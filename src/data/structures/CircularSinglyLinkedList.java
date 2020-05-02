package data.structures;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularSinglyLinkedList {
	
	static	private ListNode last;
	static private int length;
	
	public static class ListNode{
		public ListNode next;
		public int data;
		
		public ListNode( int data) {
			super();
			this.data = data;
		}
	}

	
	
	 int length() {
		return length = 0;
	}
	
	 boolean isEmpty() {
		return length==0;
	}
	
	 static public void display() {
		ListNode firts = last.next;
		while (firts!=last) {
			System.out.print(firts.data +" ");
			firts = firts.next;
		}
		System.out.print(firts.data);
	}
	
	 static public void insertBegining(int data) {
		ListNode node = new ListNode(data);
		if (last == null) {
			last = node;
		}else {		
			node.next = last.next;
		}
		last.next = node;
		length++;
	}
	
	 static public void insertAtTheEnd(int data) {
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
	
	 static public void deleteFirst() {
		ListNode first = last.next;
		last.next = first.next;
		first= first.next;
	}
	
	 static public void deleteLast() {
		ListNode temp = last;
		while (temp.next != last) {
			temp = temp.next;
		}
		temp.next = last.next;
		last=null;
		last=temp;
	}
	
	 static public void deletePosition(int index) {
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
	
	public static void print(int index) {
		ListNode pHead = null;
		ListNode p = last;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		ListNode b = p.next;
		while (p!=b) {
			System.out.print(b.data+" ");
			b=b.next;
		}
		System.out.print(b.data +" ");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			insertAtTheEnd(x);
		}
		int k = sc.nextInt();
		print(k);
		
		
	}
	
}
