package deapthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Vertex> list = new ArrayList<>();
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		v1.addNeightB(v2);
		v1.addNeightB(v3);
			
		BFS bfs = new BFS();
		bfs.bfs(v1);
	}
}
