package maxflow;

public class Vertex {
	
	private int size;
	private Object[] obj;
	
	public Vertex(int size) {
		this.size = size;
		obj = new Object[size];
	}
	
	public int getVertex() {
		return size;
	}

}
