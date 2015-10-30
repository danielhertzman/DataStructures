package maxflow;

public class FlowEdge {
	
	private int v, w;
	private int capacity;
	private int flow;
	private boolean visited;
	
	public FlowEdge(int v, int w, int capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public int flow() {
		return flow;
	}
	
	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w) 
			return v;
		else
			throw new RuntimeException("Illegal endpoint");
	}
	
	public int residualCapacity(int vertex) {
		if (vertex == v)
			return flow;
		else if (vertex == w)
			return capacity - flow;
		else
			throw new IllegalArgumentException();
	}

}
