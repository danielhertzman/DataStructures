package Assignment3;

/**
 * Class that represents a binary search tree
 * 
 * @author danielhertzman-ericson
 *
 */
public class BinaryTree {

	private TreeNode root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	/**
	 * Adds new elements to the tree
	 * @param data the data to be inserted
	 */
	public void add (int data) {
		TreeNode newNode = new TreeNode(data);
		if (root ==  null){
			root = newNode;
		}
		else {
			root = insert(root, newNode);
		}
		
	}
	
	/**
	 * Actually inserts the new elements to the tree
	 * It returns a new node for every node inserted
	 * @param current
	 * @param newNode
	 * @return
	 */
	public TreeNode insert(TreeNode current, TreeNode newNode){
		
		if (current == null) {
			current = newNode;
			return current;
		}

		else if (current.getData() > newNode.getData()) {
			if (current.getLeft() == null) {
				current.setLeft(new TreeNode(newNode.getData()));
			} else {
				insert(current.getLeft(), newNode);
			}
		}

		else if (current.getData() < newNode.getData()) {
			if (current.getRight() == null) {
				current.setRight(new TreeNode(newNode.getData()));
			} else {
				insert(current.getRight(), newNode);
			}
		}

		else if (current.getData() == newNode.getData()) {
			try {
				throw new Exception();
			} catch (Exception e) {
			}
		}

		return current;
 				
	}
	
	public void delete (int data){
		root = remove (root, data);
	}
	
	public TreeNode remove (TreeNode node, int data){
		if (node.getData() == data) {

			if (node.getLeft() == null && node.getRight() == null) {
				node = null;

			} else if (node.getLeft() != null && node.getRight() == null) {
				TreeNode left = node.getLeft();
				node.setData(left.getData());

				node.setRight(left.getRight());
				node.setLeft(left.getLeft());

			} else if (node.getRight() != null && node.getLeft() == null) {
				TreeNode right = node.getRight();
				node.setData(right.getData());

				node.setRight(right.getRight());
				node.setLeft(right.getLeft());
			}

			else {
				TreeNode successor = findSuccessor(node);
				node.setData(successor.getData());

				if (node.getRight() == successor) {
					node.setRight(successor.getRight());

				} else {
					deleteSuccessor(node.getRight(), successor, null);

				}
			}

		} else if (data < node.getData()) {
			node.setLeft(remove(node.getLeft(), data));

		} else if (data > node.getData()) {
			node.setRight(remove(node.getRight(), data));
		}

		return node;
    }
	
	private TreeNode findSuccessor (TreeNode current){
		TreeNode node = current.getRight();
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
	
	private TreeNode deleteSuccessor(TreeNode node, TreeNode success, TreeNode parent){
		if (success == node) {
			parent.setLeft(node.getRight());

		} else if (success.getData() < node.getData()) {
			deleteSuccessor(node.getLeft(), success, node);


		} else if (success.getData() > node.getData()) {

			deleteSuccessor(node.getRight(), success, node);

		}

		return parent;
	}
	
//	private void inOrder(TreeNode current){
//		
//	}
	
	public TreeNode find(TreeNode current, int data){
		
		if (current.getData() == data) {
			return current;
		}
		
		else if (current.getData() > data) {
			return find(current.getLeft(), data);
		}

		else if (current.getData() < data) {
			return find(current.getRight(), data);
		}

		return null;
	}
	
	public void print (){
		root.printTree();
	}
	
}