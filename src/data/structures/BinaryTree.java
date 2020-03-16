package data.structures;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	static Node root;
	public static class Node{
		
		 Node left;
		 Node right;
		 int data;
		public Node(int data) {
			super();
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}
	
	public void implement() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		root = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
	}
	
	public void preOrder(Node node){
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
		
	}
	
	public void inOrder(Node node) {
		if (node == null) return;
		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.data);
	}
	
	public void inOrderByLoop() {
		if(root==null) throw new NoSuchElementException();
		Stack<Node> nodes = new Stack<>();
		Node temp = root;
		while (!nodes.isEmpty() || temp!=null) {
			if (temp.left != null) {
				nodes.push(temp);
				temp = temp.left;
			}else {
				temp = nodes.pop();
				System.out.println(temp.data);
				temp = temp.right;
			}
			
		}
	}
	
	public void postOrderByLoop() {
		if (root == null) {
			throw new NoSuchElementException();
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.data);
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
			
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.implement();
		tree.postOrderByLoop();
	}
	
}
