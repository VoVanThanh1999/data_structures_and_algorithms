package data.structures;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

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
	
	static	boolean isPrime(int n) {
		if (n<2)
			return false;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n%i==0) 
				return false;
		}
		return true;
	}
	
	static void superPrimeNumber() {
		Scanner sc = new Scanner(System.in);
		java.util.Queue<Integer> queue = new LinkedList<Integer>();
		int n = sc.nextInt();
		for (int i =2;  i < 10 && i<=n ; i++) {
			if (isPrime(i)) 
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 1; i <= 9; i++) {
				int k = queue.element()*10+i;
				if (isPrime(k)&& k < n) {
					queue.offer(k);
				}
			}
			System.out.print(queue.element()+" -> ");
			queue.poll();
		}
	}
	
	public static void saveNumberPhone() {
		Scanner sc = new Scanner(System.in);
		java.util.Queue<Integer> q = new LinkedList<>();
		boolean b[] = new boolean[100];
		int a[] = new int[100];
		int n = sc.nextInt();
		for (int i = 0; i < 100; i++) {
			b[i] = false;
		}
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			if (!b[a[i]]) {
				if (q.size()<k) {
					b[a[i]] = true;
					q.offer(a[i]);
				}else {
					b[q.element()] = false;
					b[a[i]] = true;
					q.offer(a[i]);
					q.poll();
				}
			}
		}
		
		while (!q.isEmpty()) {
			System.out.print(q.poll());
			
		}
	}
	
	public static int javaDequeue(Deque<Integer> deque,int n) {
		List<Integer> list = new LinkedList<>(deque);	
		int max = 0;
		for (int i = 0; i <=list.size()-n ; i++) {
			Set<Integer> hashSets = new HashSet<>();
			int count = i;
			while (count<i+n) {
				hashSets.add(list.get(count));
				count++;
			}
			if (hashSets.size()>max) {
				System.out.println(hashSets.size());
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		/*saveNumberPhone();*/
		Deque<Integer> deque =new LinkedList<>();
		deque.offer(5 );
		deque.offer(3 );
		deque.offer(5 );
		deque.offer(2 );
		deque.offer(3);
		deque.offer(2);
		System.out.println(javaDequeue(deque,3));
	
	}
}
