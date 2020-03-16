package data.structures;

import java.util.NoSuchElementException;

public class Queue {
	
	Node front;
	Node rear;
	int length = 0;
	
	public static class Node{
		int data;
		private Node next;
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean isEmpty() {
		return length ==0;
	}
	
	public int enqueue(int data) {
		Node node = new Node(data);
		if (isEmpty()) {
			front= node;
			rear = node;
		}else {
			node.next=front;
			front=node;
		}
		length++;
		return node.data;
	}
	
	public int dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int result = front.data;
		front=front.next;
		if (front == null) {
			rear = null;
		}
		length--;
		return result;
	}
	
	public void show() {
		Node node = front;
		while (node.next!=null) {
			System.out.print(node.data +" -> ");
			node=node.next;
		}
		System.out.print(node.data +" -> ");
	}
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(1);  
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		System.out.println(queue.dequeue());
	}
}
