package data.structures;

import java.util.NoSuchElementException;
public class DoublyLinkedList {
	public static class Node {
		Node previous;
		Node next;
		int data;

		public Node(int data) {
			super();
			this.previous = null;
			this.next = null;
			this.data = data;
		}
	}

	static Node pHead;
	static Node pTail;
	public int length = 0;

	public void show(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print(node.data + " -> null");
	}

	public void showAtLast(Node pTail) {
		try {
			Node node = pTail;
			while (pTail.previous != null) {
				System.out.print(node.data + " ");
				node = node.previous;
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	public boolean isEmpty() {
		return length == 0;
	}

	private void insertTheEnd(int data) {
		// TODO Auto-generated method stub
		Node node = new Node(data);
		if (isEmpty()) {
			pHead = node;
		} else {
			pTail.next = node;
			node.previous = pTail;

		}
		pTail = node;
		length++;
	}

	public void deleteFirst() {
		Node node = pHead;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			node.next.previous = null;
		}
		pHead = pHead.next;
		node.next = null;
		length--;
	}


	public void deleteLast() {
		Node node = pTail;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		node.previous.next = null;
		pTail = pTail.previous;
		node.previous = null;
		length --;
	}
	
	public void deletePosition(int index) {
		try {
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			if (index > length || index == 0) {
				return;
			}
			
			Node node = pHead;
			Node temp = null;
			int count = 1;
			while (node.next != null && count < index) {
				node = node.next; 
				count++;
			}
			temp = node.next;
			node.next = temp.next;
			node.next.previous = temp.previous;
			temp.next = null;
			temp.previous = null;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertPosition(int index,int data) {
		Node node = new Node(data);
		Node curent = pHead;
		Node curent1 = pHead;
		Node temp = null;
		if (index==1) {
			pHead = node;
			pTail= node;
			return;
		}
		int countTemp = 1;
		while (curent.next!= null ) {
			curent1 = curent1.next;
			countTemp++;
			
		}
		if(countTemp == index) {
			node.previous =pTail;
			pTail.next = node;
			return;
		}
		
		int count = 1;
		while (curent.next != null && count < index) {
			curent = curent.next;
			count++;
		}
		temp = curent.next;
		node.next = temp;
		temp.previous = node;
		curent.next = node;
		node.previous = curent;
		
	}
	

	public static void main(String[] args) {
		DoublyLinkedList linkedList = new DoublyLinkedList();
		linkedList.insertTheEnd(1);
		linkedList.insertTheEnd(1);
		linkedList.insertTheEnd(2);
		linkedList.insertTheEnd(3);
		linkedList.insertPosition(2, 15);
		linkedList.show(pHead);
	}
}
