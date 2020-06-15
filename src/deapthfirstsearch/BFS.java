package deapthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public Queue<Vertex> queue;

	public BFS() {
		super();
		this.queue = new LinkedList<Vertex>();
	}

	public void bfs(Vertex v) {
		v.setVisited(true);
		bfsNeghtB(v);
	}

	private void bfsNeghtB(Vertex v) {
		// TODO Auto-generated method stub
		v.setVisited(true);
		queue.offer(v);
		while (!queue.isEmpty()) {
			Vertex vertex = queue.poll();
			System.out.print(vertex.name);
			for (Vertex v1 : vertex.neightB) {
				if (!v1.isVisited()) {
					v1.setVisited(true);
					queue.offer(v1);
				}
			}

		}
	}

}
