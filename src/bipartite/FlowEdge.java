package bipartite;

public class FlowEdge {
	
	private int v, w;
	private int capacity;
	private int flow;
	
	public FlowEdge(int v, int w, int capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}

}
