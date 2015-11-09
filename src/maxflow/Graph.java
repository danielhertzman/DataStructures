package maxflow;
import javax.swing.JOptionPane;
import assignment1.*;


public class Graph {
	
	private int[][] graph; // Creates a 2-deminsional graph.
	private Stack stack = new Stack(); // Implements the abstract datastructure 'Stack'
	private int from; // Creating a variable 'from', this will hold the start value of the graph.
	private int to; // Creating a variable ' to' this will be represent the final destination of the graph.
	private int[] path; // Creating an array 'path', this array will hold the path that has been chosen.
	private int size; // 'size' will represent the size of the each array in the 2-dimensional array.
	private boolean[] visited; // Creating an array 'visited' which will remember the positions in the 2-D array that we have visited.
	
	/**
	 * Creates a Graph, the user will assign the amount of nodes that the graph will contain.
	 */
	public Graph() {
		from = Integer.parseInt(JOptionPane.showInputDialog("Ange antal vänsternoder"));
		to = Integer.parseInt(JOptionPane.showInputDialog("Ange antal högernoder"));;
		
		size = (from + to) + 2; // 'size' is assigned the amount of nodes + 2 nodes. The extra two nodes are representing the Sink and Terminal.
		graph = new int[size][size]; // The 2-dimensional array 'graph' is now set to size * 2.
		path = new int[size]; // 'path' is also assigned the same value as 'size', since the two arrays must be equivalent to each other.
		visited = new boolean[size]; // 'visited' is a copy of 'path', but holds boolean values instead of integers.
	}
	
	/**
	 *  Initializes the graph by creating the 'from'-nodes and 'to'-nodes that Terminal and Sink always are connected to. 
	 *  The Sink and Terminal variables are excluded in this initialization, since they are constant nodes,
	 *  and are always included.
	 */
	
	public void initializeGraph() {
		for (int i = 1; i <= from; i++) { // Initializes the nodes connected to the Source, position 0.
            graph[0][i] = 1;
        }
		
		for (int i = from +1;i < graph.length-1; i++) { // Initializes the nodes connected to the Terminal, last position.
			graph[i][graph.length-1] = 1;
		}
		
		while (true) { // Creates a connection from a chosen left-node to a chosen right-node.
			
			int r, l;
			int yes;
			
			r = Integer.parseInt(JOptionPane.showInputDialog("Ange connection från vänsternod..."));
			l = Integer.parseInt(JOptionPane.showInputDialog("...till högernod.."));
			
			yes = JOptionPane.showConfirmDialog(null, "Är du färdig?");	
			if(yes == JOptionPane.YES_OPTION) {
				break;
			} else {
				makeConnections(r, l);
			}		
			
		}
		
	}
	
	/**
	 * Passes on the given values to this operation, and actually assigns the values to the graph.
	 * @param from - where we want to start from.
	 * @param to - where want to go to.
	 */
	private void makeConnections(int from, int to) { 
		graph[from][to] = 1;
	}
	
	/**
	 * This DFS (Deapth-First search) method, operates on the two arrays 'visited' and 'path'. Initializing the positions in both of them.
	 *  
	 * @param graph - receives the graph created in the "public Graph()" method above.
	 * @param s - symbolices the source, the start-node.
	 * @param t - symbolices the terminal, the end-node.
	 * @return - returns true if a path from source to terminal is found.
	 */
	private boolean DFS(int[][] graph, int s, int t) {
		
		boolean found = false; // found is first set to false, will be set to true below if a path is found.
		int element;
		
		/*
		 * Initializing each position in the array 'visited' and setting it to 'false', and each position in the 
		 * array 'path' is set to contain the value 0.
		 */
		
		for (int i = 0; i < size; i++) {
			visited[i] = false;
			path[i] = 0;
		}
		
		visited[s] = true;
		stack.push(s); // Pushes the Sink (which is set to 0) to the Stack. The Sink in the graph is always set to 0.
		path[s] = -1; // the position 's' in 'path' is set to -1 to exclude it from the DFS search.
		
		// Iterating through the visited array, the graph and'path' array.
		while(stack.size() > 0) {
			
			element = (int) stack.pop(); //Assigns the last pushed element in the Stack to the variable 'element', and removes it from the Stack. 
										 //The first iteration in the while loop will always assign the value 0 to 'element'.
			
			for (int i = 0; i < size; i++) { //For each iteration:
				
				if (!visited[i] && graph[element][i] == 1) { //Checks if the position 'i' in the array 'visited' is set to false, that the
															 //'element' variable and the 'i' is equivalent to 1. If the conditions are met, the following code will execute:
					
					stack.push(i); //Pushes the value of 'i' to the stack.
					path[i] = element; //The position 'i' in the array 'path' is assigned the integer value that the variable 'element' currently is holding.
					visited[i] = true; //The position 'i' in the array 'visited' is now set to true, instead of false.
				}
			}
		}
		
		if (visited[t]) {
			found = true;
		}
		
		return found;
		
	}
	
	/**
	 * This method follows the Ford Fulkersons' algorithm on traversing a graph.
	 * @param graph - takes in the created graph.
	 * @param s - takes in the source node.
	 * @param t - takes in the terminal node.
	 * @return returns the maxflow, that is: the maximum flows found in the graph.
	 */
	public int ff(int[][] graph, int s, int t) {
		
		int u = -1, v = -1;
		int maxflow = 0;
		int[][] residualGraph = new int[size][size]; // This graph is a 2-dimensional graph, equivalent to the first created 'graph' above.
		
		// copying the graph above to the residual graph.
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[0].length; j++) {
				residualGraph[i][j] = graph[i][j];
			}
		}
		
		while (DFS(residualGraph, s, t)) { //Using the DFS search on the residual graph with Ford Fulkersons' algorithm.
			
			int flowCapacity = Integer.MAX_VALUE; // 'flowCapacity' is set to maximum value at first.
			v = t; // node 'v' is assigned node 't's' value.
			
			/*
			 *  As long as node 'v' (the current node we are on) is not equal to node 's' (the source node), we are 
			 *  traversing the graph, searching it. Memorazing the paths in the graph.
			 */
			while (v != s) {
				u = path[v]; //
				flowCapacity = Math.min(residualGraph[u][v], flowCapacity); // flowCapacitys' value is balanced out by lowering it from the maximum integer value to the 
																		    // value of the vent-weigh.
				v = u; // the node 'v' is set to node 'u' (the next node in the graph).
			}
			
			v = t; // The graph has been traversed with the above while-loop, and 'v' is now restored to equal 't' again. Another while-loop is started.
			
			/*
			 * Going back to the source node. 
			 * As long as the 'v' (current node) is not equal to the 's' node (source node), we are
			 * traversing the graph, searching for the it. This time, calculating the flowcapacity in the graph.
			 */
			while (v != s){
				u = path[v];
				residualGraph[u][v] -= flowCapacity;
				residualGraph[v][u] += flowCapacity;
				
				// prints the chosen paths between the nodes connected to 's' and 't'.
				if(path[u] > s && path[v] < t){
					System.out.println(path[u] + " " + path[v]);
				}
				v = u;
				
			}
			
			maxflow += flowCapacity;
						
		}
		
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
