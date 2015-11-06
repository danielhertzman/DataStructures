package project;

import java.util.*;

public class Graph {
	
	private HashMap<Node, LinkedList<Connection>> map;
	private Set<Map.Entry<Node, LinkedList<Connection>>> set;
	
	public Graph(HashMap<Node, LinkedList<Connection>> adjacencyMap) {		
		this.map = adjacencyMap;
		this.set = adjacencyMap.entrySet();
	}
	
	public Graph() {
		map = new HashMap<Node, LinkedList<Connection>>();
	}
	
	public Graph getResidualGraph() {
		Graph residual = new Graph();
		
		
		return residual;
	}
	
	

	public HashMap<Node, LinkedList<Connection>> getMap() {
		return map;
	}

	public void setMap(HashMap<Node, LinkedList<Connection>> map) {
		this.map = map;
	}

	public Set<Map.Entry<Node, LinkedList<Connection>>> getSet() {
		return set;
	}

	public void setSet(Set<Map.Entry<Node, LinkedList<Connection>>> set) {
		this.set = set;
	}
	
	
}