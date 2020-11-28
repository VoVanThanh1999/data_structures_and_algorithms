package data.structures;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	public static class ListNode{
		ListNode next;
		int data;
		
		public ListNode( int data) {
			super();
			this.next = null;
			this.data = data;
		}
		
	}
	
	ListNode top;
	int length =0;
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void push(int data) {
		ListNode listNode = new ListNode(data);
		listNode.next = top;
		top = listNode;
		length++;
	}
	
	public int peek() {
		int data = top.data;
		top = top.next;
		length--;
		return data;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.peek());
	}
}
