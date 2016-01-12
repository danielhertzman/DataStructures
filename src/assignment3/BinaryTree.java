package assignment3;

/**
 * Class that represents a binary search tree
 *
 * @author danielhertzman-ericson
 */
public class BinaryTree {

    protected TreeNode root;
    protected int size;

    public BinaryTree() {

        size = 0;
    }

    /**
     * Adds the specified value to the tree recursively.
     *
     * @param data
     */
    public void add(int data) {

        try {

            root = insert(root, new TreeNode(data));
            size++;

        } catch (Exception e) {}
    }

    /**
     * Used by add for recursively adding the newNode. Throws Exception if the value exists in the tree.
     *
     * @param current
     * @param newNode
     * @return The root for the new tree or subtree.
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
     * Removes the value from the tree, if it exists, recursively.
     *
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
     * Removes the data from the tree with current as root.
     *
     * @param current
     * @param data
     * @return The root for the new tree or subtree.
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
     * Finds the node with the specified value in the tree with current as root.
     *
     * @param current
     * @param data
     * @return The node containing the specified value
     */
    public TreeNode find(TreeNode current, int data) {

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
     * Finds and returns the successor of the current node.
     *
     * @param current
     * @return The successor of the current node
     */
    protected TreeNode findSuccessor(TreeNode current) {

        TreeNode successor;

        if (current == null) {
            successor = null;

        } else if (current.getRight() != null) {
            if (current.getLeft() == null) {
                successor = current.getRight();

            } else {
                successor = getMinimum(current.getRight());
            }

        } else if (current.getLeft() != null) {
            successor = current.getLeft();

        } else {
            successor = current;
        }

        return successor;
    }

    /**
     * Finds the parent TreeNode node for the child. Starts with the current.
     *
     * @param current
     * @param child
     * @return returns the parent TreeNode. Returns null if the node has no parents or is not found in the tree.
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
     * Returns the minimum value(the leftmost child) of the tree with current as root.
     *
     * @param current
     * @return The minimum value of the tree with current as root.
     */
    private TreeNode getMinimum(TreeNode current) {

        if (current.getLeft() != null) {
            return getMinimum(current.getLeft());

        } else {
            return current;
        }
    }

    /**
     * Prints the values of the tree, with current as root, in order.
     *
     * @param current
     */
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
     * @return The size of the tree.
     */
    public int getSize() {

        return size;
    }

    /**
     * Prints the tree from the root.
     */
    public void print() {

        root.printTree();
    }
}