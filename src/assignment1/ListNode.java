package Assignment1;

/**
 * Represents every node in a linked list. 
 * @author danielhertzman-ericson
 *
 */
public class ListNode {
	
	private Object data;
	private ListNode nextNode;
	
	public ListNode(Object data, ListNode nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
	
	/**
	 * Returns the object data 
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	
	/*
	 * Since I'm no fan of declaring
	 * public instance variables, I'm just
	 * creating a standard get-method to get the 
	 * next node.
	 */
	public ListNode next() {
		return nextNode;
	}
	
	/*
	 * 
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
