package deapthfirstsearch;

import java.util.Stack;

public class DFS {
	
	public Stack<Vertex> stack;

	public DFS() {
		super();
		this.stack = new Stack<>();
	}
	
	public void dfs(Vertex v) {
		if (v.visited==true) {
			System.out.println("Đỉnh đã được thăm");
			return;
		}
		v.setVisited(true);
		visitedNeightB(v);
	}

	private void visitedNeightB(Vertex vFirst) {
		// TODO Auto-generated method stub
		stack.add(vFirst);
		while (!stack.isEmpty()) {
			Vertex vertex = stack.pop();
			System.out.print(vertex.name+" -> ");
			for (Vertex v : vertex.getNeightB()) {
				if (v.isVisited()==false) {
					v.setVisited(true);
					stack.add(v);
				}
			}
		}
	}
	
	
	
	
}	
