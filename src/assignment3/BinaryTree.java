package assignment3;

/**
 * Class that represents a binary search tree. Is to be extended by
 * an AVL-tree
 *
 * @author danielhertzman-ericson
 */
public class BinaryTree {

    protected TreeNode root;
    protected int size;

    /**
     * Constructor with sets size
     * to 0 for every new tree
     */
    public BinaryTree() {

        size = 0;
    }


    /**
     * Add an integer elemnet to the tree
     * @param data
     */
    public void add(int data) {

        try {

            root = insert(root, new TreeNode(data));
            size++;

        } catch (Exception e) {}
    }


    /**
     * Inserts the element to the tree. Throws Exception if
     * data is equal to data already stored in the tree.
     * @param current
     * @param newNode
     * @return
     * @throws Exception
     */
    private TreeNode insert(TreeNode current, TreeNode newNode) throws Exception {

        if (current == null) {

            return newNode;

        } else if (current.getData() == newNode.getData()) {
            throw new Exception();

        } else if (current.getData() > newNode.getData()) {
            current.setLeft(insert(current.getLeft(), newNode));

        } else if (current.getData() < newNode.getData()) {
            current.setRight(insert(current.getRight(), newNode));
        }

        return current;
    }


    /**
     * Delete an integer data from tree
     * @param data
     */
    public void delete(int data) {
        TreeNode temp = remove(root, data);

        if (temp != null) {
            root = temp;
            size--;
        }
    }

    /**
     * Removes the node containing the data specified in the
     * delete method
     * @param current
     * @param data
     * @return
     */
    private TreeNode remove(TreeNode current, int data) {

        TreeNode node = find(current, data);

        if (node != null) {

            TreeNode successor = findSuccessor(node);
            TreeNode successorParent = findParent(current, successor);

            if (successorParent == node) {

                if (node.getData() < successor.getData()) {

                    node.setRight(successor.getRight());

                    if (node.getLeft() == null) {
                        node.setLeft(successor.getLeft());
                    }

                } else {
                    node.setRight(successor.getRight());
                    node.setLeft(successor.getLeft());
                }

            } else if (successorParent.getLeft() != null) {

                successorParent.setLeft(successor.getRight());

            } else if (successor == node) {

                if (successorParent.getData() > successor.getData()) {
                    successorParent.setLeft(null);
                } else {
                    successorParent.setRight(null);
                }
            }
            node.setData(successor.getData());
        }
        return current;
    }

    /**
     * Find a node with a data
     * @param current
     * @param data
     * @return
     */
    private TreeNode find(TreeNode current, int data) {

        if (current == null) {
            return null;

        } else if (current.getData() == data) {
            return current;

        } else if (current.getData() > data) {
            return find(current.getLeft(), data);

        } else if (current.getData() < data) {
            return find(current.getRight(), data);
        }

        return null;

    }

    /**
     * Find the successor node to a specified node
     * @param current
     * @return
     */
    protected TreeNode findSuccessor(TreeNode current) {

        TreeNode successor;

        if (current == null) {
            successor = null;

        } else if (current.getRight() != null) {
            if (current.getLeft() == null) {
                successor = current.getRight();

            } else {
                successor = getLeftMost(current.getRight());
            }

        } else if (current.getLeft() != null) {
            successor = current.getLeft();

        } else {
            successor = current;
        }

        return successor;
    }

    /**
     * Find a parent to a child node
     * @param current
     * @param child
     * @return
     */
    protected TreeNode findParent(TreeNode current, TreeNode child) {

        if (child == null) {
            return null;

        } else if (current.getData() > child.getData()) {
            if (current.getLeft() == child) {
                return current;
            } else {
                return findParent(current.getLeft(), child);
            }

        } else if (current.getData() < child.getData()) {
            if (current.getRight() == child) {
                return current;
            } else {
                return findParent(current.getRight(), child);
            }
        }

        return null;
    }

    /**
     * Get the left-most node
     * @param current
     * @return
     */
    private TreeNode getLeftMost(TreeNode current) {

        if (current.getLeft() != null) {
            return getLeftMost(current.getLeft());

        } else {
            return current;
        }
    }

    public void inOrder(TreeNode current) {

        if (current == null) {
            inOrder(root);

        } else {

            if (current.getLeft() != null) {
                inOrder(current.getLeft());
            }

            System.out.println(current.getData());

            if (current.getRight() != null) {
                inOrder(current.getRight());
            }
        }
    }

    /**
     * Returns size of the tree
     * @return
     */
    public int getSize() {

        return size;
    }

    /**
     * Prints the tree
     */
    public void print() {

        root.printTree();
        System.out.println();
        inOrder(root);
    }
}