import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex {
	private int id;
	private int inDegree;
	private ArrayList<Vertex> adj = null;

	public Vertex(int id) {
		super();
		this.id = id;
		adj = new ArrayList<Vertex>();
		;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

	public ArrayList<Vertex> getAdj() {
		return adj;
	}

	public void setAdj(ArrayList<Vertex> adj) {
		this.adj = adj;
	}

}

public class TopologicalSortByDegreeCount {

	static ArrayList<Vertex> vertices = new ArrayList<Vertex>();

	static void addEdge(Vertex s, Vertex d) {
		s.getAdj().add(d);
		d.setInDegree(d.getInDegree() + 1);
	}
	
	private List<Integer> topologicalSort(ArrayList<Vertex> vertices) {
		Queue<Vertex> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<Integer>();
		for (Vertex v : vertices) {
			if (v.getInDegree() == 0) {
				queue.add(v);
			}
		}

		while (!queue.isEmpty()) {
			Vertex zeroIndDegree = queue.poll();
			res.add(zeroIndDegree.getId());
			for (Vertex v : zeroIndDegree.getAdj()) {
				v.setInDegree(v.getInDegree() - 1);
				if (v.getInDegree() == 0)
					queue.add(v);
			}
		}
		
		if (res.size() != vertices.size())
			throw new RuntimeException("There might be cycles so could not generate topological seq");
		
		return res;
	}

	// Driver code
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		TopologicalSortByDegreeCount g = new TopologicalSortByDegreeCount();
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);

		addEdge(v5, v2);
		addEdge(v5, v0);
		addEdge(v4, v0);
		addEdge(v4, v1);
		addEdge(v2, v3);
		addEdge(v3, v1);
		addEdge(v3, v4);

		System.out.println("Following is a Topological " + "sort of the given graph \n" + g.topologicalSort(vertices));
	}

}
