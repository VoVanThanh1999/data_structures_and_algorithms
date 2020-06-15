package deapthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	public String name;
	public boolean visited;
	public List<Vertex> neightB;

	public Vertex(String name) {
		super();
		this.name = name;
		this.neightB = new ArrayList<>();
	}

	public void addNeightB(Vertex vertex) {
		this.neightB.add(vertex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeightB() {
		return neightB;
	}

	public void setNeightB(List<Vertex> neightB) {
		this.neightB = neightB;
	}

}
