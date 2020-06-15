package data.structures;
import java.util.List;
import java.util.ArrayList;


public class CircularSinglyLinkedList {

	static private ListNode last;
	static private int length;

	public static class ListNode {
		public ListNode next;
		public int data;

		public ListNode(int data) {
			super();
			this.data = data;
		}
	}

	int length() {
		return length = 0;
	}

	boolean isEmpty() {
		return length == 0;
	}

	static public void display() {
		ListNode firts = last.next;
		while (firts != last) {
			System.out.print(firts.data + " ");
			firts = firts.next;
		}
		System.out.print(firts.data);
	}

	static public void insertBegining(int data) {
		ListNode node = new ListNode(data);
		if (last == null) {
			last = node;
		} else {
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
		} else {
			listNode.next = last.next;
			last.next = listNode;
			last = listNode;
		}
		length++;
	}

	static public void deleteFirst() {
		ListNode first = last.next;
		last.next = first.next;
		first = first.next;
	}

	static public void deleteLast() {
		ListNode temp = last;
		while (temp.next != last) {
			temp = temp.next;
		}
		temp.next = last.next;
		last = null;
		last = temp;
	}

	static public void deletePosition(int index) {
		ListNode lastNode = last;
		ListNode firtNode = last.next;
		ListNode temp = firtNode;
		int count = 0;
		while (temp.next != lastNode && count < index) {
			temp = temp.next;
			count++;
		}
		ListNode listNode = temp.next;
		temp.next = listNode.next;
		listNode.next = null;
		last = temp;

		length--;

	}

	public void insertAtPosition(int index, int data) {

	}

	public static void print(int index) {
		ListNode pHead = null;
		ListNode p = last;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		ListNode b = p.next;
		while (p != b) {
			System.out.print(b.data + " ");
			b = b.next;
		}
		System.out.print(b.data + " ");
	}

	public static int josephusSurvivor(final int n, final int k) {
		List<Integer> list = new ArrayList<>();
		int value = 1;
		while (value <= n) {
			list.add(value);
			value++;
		}
		int count = k - 1;
		while (list.size() != 1) {
			for (int i = 0; i < list.size() && count < list.size(); i++) {
				if (i == count) {
					list.remove(i);
					count += k - 1;
				}
			}
			if (count >= list.size()) {
				count = count - list.size();
			}
		}

		return list.get(0);
	}

	public static void main(String[] args) {
		System.out.println(josephusSurvivor(100, 1));

	}

}
