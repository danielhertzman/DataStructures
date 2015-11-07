package awesome;
import javax.swing.JOptionPane;

import assignment1.*;

public class Graph {
	
	private int[][] graph;
	private Stack stack = new Stack(); //min egna stack. GLÖM EJ KOPIERA IN
	private int from;
	private int to;
	private int[] path;
	private int size;
	private boolean[] visited;
	
	public Graph() {
		from = Integer.parseInt(JOptionPane.showInputDialog("Ange antal vänsternoder"));
		to = Integer.parseInt(JOptionPane.showInputDialog("Ange antal högernoder"));;
		
		size = (from + to) + 2;
		graph = new int[size][size];
		path = new int[size];
		visited = new boolean[size];
	}
	
	public void initializeGraph() {
		for (int i = 1; i <= from; i++) {
            graph[0][i] = 1;
        }
		
		for (int i = from +1;i < graph.length-1; i++) {
			graph[i][graph.length-1] = 1;
		}
		
		for (int i = 0; i < size -2; i++) 
			makeConnections(Integer.parseInt(JOptionPane.showInputDialog("Gör connection från vänsternod..")), Integer.parseInt(JOptionPane.showInputDialog("...till högernod...")));		
		
	}
	
	private void makeConnections(int from, int to) {
		graph[from][to] = 1;
	}
	
	private boolean DFS(int[][] graph, int s, int t) {
		
		boolean found = false;
		int element;
		
		for (int i = 0; i < size; i++) {
			visited[i] = false;
			path[i] = 0;
		}
		
		visited[s] = true;
		stack.push(s);
		path[s] = -1;
		
		while(stack.size() > 0) {
			
			element = (int) stack.pop();
			
			for (int i = 0; i < size; i++) {
				
				if (!visited[i] && graph[element][i] == 1) {
					stack.push(i);
					path[i] = element;
					visited[i] = true;
				}
			}
			
		}
		
		if (visited[t]) {
			found = true;
		}
		
		return found;
		
	}
	
	public int ff(int[][] graph, int s, int t) {
		
		int u = -1, v = -1;
		int maxflow = 0;
		int[][] residualGraph = new int[size][size];
		
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[0].length; j++) {
				residualGraph[i][j] = graph[i][j];
			}
		}
		
		while (DFS(residualGraph, s, t)) {
			
			int flowCapacity = Integer.MAX_VALUE;
			v = t;
			
			while (v != s) {
				u = path[v];
				flowCapacity = Math.min(residualGraph[u][v], flowCapacity);
				v = u;
			}
			
			v = t;
				
			while (v != s){
				u = path[v];
				residualGraph[u][v] -= flowCapacity;
				residualGraph[v][u] += flowCapacity;
				v = u;
				
			}
			
			maxflow += flowCapacity;
			
//			System.out.println(path[]);
			
		}
		System.out.println("vänsternod: " + v + "högernod: " + u);
		return maxflow;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
/***********************************************************************************************/
	public void printGraph() {
		for (int i = 0; i < graph.length; i++) {
            for (int k = 0; k < graph[i].length; k++) {
                System.out.print(graph[i][k] + " ");
            }
            System.out.println();
            
        }
//		DFS(graph, 0, graph.length-1);
		System.out.println(ff(graph, 0, graph.length -1));
	}
	
	public static void main(String[] args) {
		Graph f = new Graph();
		f.initializeGraph();
		f.printGraph();
//		f.ff(graph, s, t)
	}

}
