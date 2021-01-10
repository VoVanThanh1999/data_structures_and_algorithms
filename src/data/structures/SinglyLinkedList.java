package data.structures;

import Java.SigLinkListNode.ListNode;

public class SinglyLinkedList {

	private static ListNode head;
	private static ListNode head1;

	private class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	
	private void insertStart(int data) {
		ListNode node = new ListNode(data);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	private void show(ListNode head) {
		ListNode node = head;
		if (head == null) {
			System.out.println("null ");
			return;
		}
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println(node.data);
	}

	public int length() {
		int count = 0;
		if (head == null) {
			return 0;
		} else {
			ListNode listNode = head;
			while (listNode.next != null) {
				count++;
				listNode = listNode.next;
			}
			return count;
		}

	}

	public void insertFirts(int data) {
		ListNode listNode = new ListNode(data);
		if (head == null) {
			head = listNode;
		} else {
			ListNode node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = listNode;
		}
	}

	public void insertFirts1(int data) {
		ListNode listNode = new ListNode(data);
		if (head1 == null) {
			head1 = listNode;
		} else {
			ListNode node = head1;
			while (node.next != null) {
				node = node.next;
			}
			node.next = listNode;
		}
	}

	public void insertAtPosition(int data, int index) {
		if (index < 1 || length() < index) {
			System.err.println("can't insert");
			return;
		}
		ListNode node = new ListNode(data);
		if (index == 1) {
			node.next = head;
			head = node;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < index - 1) {
				previous = previous.next;
				count++;
			}
			node.next = previous.next;
			previous.next = node;

		}
	}

	public void deleteFirts() {
		head = head.next;
	}

	public void deleteLast() {
		ListNode node = head;
		ListNode previousToLast = null;
		while (node.next != null) {
			previousToLast = node;
			node = node.next;
		}
		previousToLast.next = null;
	}

	public void deleteIndex(int index) {
		ListNode node = head;
		int count = 0;
		while (count < index) {
			node = node.next;
			count++;
		}
		ListNode temp = node.next;
		node.next = temp.next;
		temp.next = null;
	}

	public boolean search(int key) {
		ListNode node = head;
		while (node.next != null) {
			if (node.data == key)
				return true;
			node = node.next;
		}
		return false;
	}

	public ListNode reverse() {
		ListNode current = head;
		ListNode next = null;
		ListNode previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public ListNode findLinkedListInMiddle() {
		ListNode listNode = head;
		ListNode teml = head;
		int count = 0;
		while (listNode.next != null) {
			listNode = listNode.next;
			count++;
		}
		ListNode node = null;
		for (int i = 0; i < count / 2; i++) {
			teml = teml.next;
		}
		node = teml;
		return node;
	}

	public ListNode findTheEnd() {
		ListNode listNode = head;
		while (listNode.next != null) {
			listNode = listNode.next;
		}
		return listNode;
	}

	public void remodeDuplicateSorted() {
		ListNode node = head;
		while (node.next != null && node != null) {
			if (node.data == node.next.data) {
				node.next = node.next.next;
			}
			node = node.next;
		}
	}

	public void insertNodeSorted(int data) {
		ListNode newNode = new ListNode(data);
		ListNode node = head;
		while (node != null & node.data < newNode.data) {
			node = node.next;
		}
		newNode.next = node.next;
		node.next = newNode;

	}

	public void removeGivenKey(int key) {
		ListNode curent = head;
		ListNode temp = null;
		while (curent.next != null && curent.data != key) {
			temp = curent;
			curent = curent.next;
		}
		if (curent == null)
			return;
		temp.next = curent.next;

	}

	public void getNode(int index) {
		ListNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		System.out.println(node.data);
	}

	public void convert(int value, int key) {

		ListNode listNode = head;
		while (listNode.next != null) {
			if (listNode.data == value)
				listNode.data = key;
			listNode = listNode.next;
		}
		if (listNode.data == key)
			listNode.data = key;

	}

	public void deleteBigger(int k) {
		ListNode node = head;
		ListNode temp = head;
		for (int i = 0; i <= k; i++) {
			node = node.next;
		}
		int v = node.data;
		while (temp != null) {
			if (temp.data < v) {
				insertFirts1(temp.data);
			}
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.insertStart(1);
		singlyLinkedList.insertStart(2);
		singlyLinkedList.insertStart(3);
		singlyLinkedList.insertStart(6);
		singlyLinkedList.insertStart(9);
		singlyLinkedList.removeGivenKey(6);
		singlyLinkedList.show(head);

	}
}
