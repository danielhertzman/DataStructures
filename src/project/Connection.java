package project;

public class Connection {
	
	private Node first;
	private Node second;
	private int capacity;
	private int flow;
	
	public Connection(Node first, Node second, int capacity) {
		this.first = first;
		this.second = second;
		this.capacity = capacity;
		flow = 0;
	}
	
	public int getFlowDifference() {
		return capacity - flow;
	}
	
	
	public Connection getResidualConnection() {
		return new Connection(first, second, getFlowDifference());
	}

}
