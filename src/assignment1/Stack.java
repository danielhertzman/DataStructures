package assignment1;

import javax.swing.JOptionPane;

/**
 * Representation of a Stack.
 * Uses the LIFO-principle.
 * @author danielhertzman-ericson
 *
 */
public class Stack {
	private int nbrOfElements = 0;
	private ListNode firstNode;
	
	/**
	 * Inserts new elements to the stack on
	 * "the top". Thus the term "push". 
	 * @param dataIn The object to be inserted
	 */
	public void push(Object dataIn) {
		
		/*
		 * If the stack contains 0 elements, we create a single node,
		 * which points at no other node, since it's the first.
		 */
		if (nbrOfElements == 0) {
			firstNode = new ListNode(dataIn, null);
			nbrOfElements++;
		}
		
		/*
		 * If there is 1 or more elements in the stack, we make the new node
		 * to point at the node first node. We then set new first node to be 
		 * the new node, in order to implement the LIFO-principle.
		 */
		else if (nbrOfElements >= 1) {
			ListNode newNode = new ListNode(dataIn, firstNode);
			firstNode = newNode;
			nbrOfElements++;
		}

	}
	
	/**
	 * Returns and removes the element
	 * in the first node.
	 * @return the element
	 */
	public Object pop() {
		
		ListNode ref; // Creating a temporary reference to the first node and then returning its data
		
		if (firstNode != null) {
		
			ref = firstNode;
			firstNode = firstNode.next(); // Since we are pop'ing the first node, we now need to set the new first node to be the next node.
			nbrOfElements--;
			return ref.getData();
			
		}
		
		return null; 
				
	}
	
	/**
	 * Returns the size of the Stack
	 * @return the size of the Stack
	 */
	public int size() {
		return nbrOfElements;
	}
	
	/**
	 * Checks if the the Stack is empty
	 * @return true if the stack is empty 
	 */
	public boolean isEmpty() {
		return nbrOfElements==0;
	}
	
	/**
	 * Allows you to "peek" at the 
	 * first element in the Stack. 
	 * We return the value of the first node
	 * without removing it. Figuratively
	 * peeking at it.
	 * @return the element
	 */
	public Object peek() {
		
		ListNode ref = firstNode;
		
		if (ref != null) {
			
			return ref.getData();
			
		} 
		
		return null; 
		
	}
	
	/*
	 * Just to test that my algorithm works.
	 * 
	 */
	
	public static void main(String[] args) {
		Stack s = new Stack();

//		for (int i = 0; i <= 10; i++) {
//			s.push(i);
//		}
//
//		for (int i = 0; i <= 10; i++) {
//			System.out.println(s.pop());
//		}
		
		//--------TextInput test---------------
		
		StringValidator input = new StringValidator(JOptionPane.showInputDialog("Write some text"), s);
		System.out.println(input.checkText());

	}
}
