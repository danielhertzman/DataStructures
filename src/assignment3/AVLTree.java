package assignment3;

/**
 * Implementation of AVL tree.
 *
 * @author danielhertzman-ericson
 */
public class AVLTree extends BinaryTree {

    /**
     * Empty constructor
     */
    public AVLTree() {}

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
            current = newNode;
            current.setHeight();

        } else if (current.getData() == newNode.getData()) {
            throw new Exception();

        } else if (current.getData() < newNode.getData()) {
            current.setRight(insert(current.getRight(), newNode));

        } else if (current.getData() > newNode.getData()) {
            current.setLeft(insert(current.getLeft(), newNode));

        }

        current.setHeight();
        current = balance(current);
        return current;
    }

    /**
     * Method that checks the height of both left and
     * right side
     * @param current
     * @return
     */
    private TreeNode balance(TreeNode current) {

        TreeNode replace = current;

        if (current.getDifference() == 2) {
            if (current.getLeft().getDifference() == -1) {
                current.setLeft(leftRotation(current.getLeft()));
            }
            replace = rightRotation(current);

        } else if (current.getDifference() == -2) {
            if (current.getRight().getDifference() == 1) {
                current.setRight(rightRotation(current.getRight()));
            }
            replace = leftRotation(current);
        }

        return replace;
    }

    /**
     * Method for right rotation
     * @param current
     * @return
     */
    private TreeNode rightRotation(TreeNode current) {

        if (current == root) {
            root = root.getLeft();
            current.setLeft(root.getRight());
            root.setRight(current);
            current.setHeight();
            root.setHeight();
            return root;

        } else {
            TreeNode left = current.getLeft();
            current.setLeft(left.getRight());
            left.setRight(current);
            current.setHeight();
            left.setHeight();
            return left;
        }
    }

    /**
     * Method for left rotation
     * @param current
     * @return
     */
    private TreeNode leftRotation(TreeNode current) {

        if (current == root) {
            root = root.getRight();
            current.setRight(root.getLeft());
            root.setLeft(current);
            current.setHeight();
            root.setHeight();
            return root;

        } else {
            TreeNode right = current.getRight();
            current.setRight(right.getLeft());
            right.setLeft(current);
            current.setHeight();
            right.setHeight();
            return right;
        }
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

        TreeNode successor = findSuccessor(current);
        TreeNode successorParent = findParent(root, successor);

        if (current == null){}

        else if (current.getData() < data) {
            current.setRight(remove(current.getRight(), data));

        } else if (current.getData() > data) {
            current.setLeft(remove(current.getLeft(), data));

        } else if (current.getData() == data) {

            if (successor == current) {
                return null;

            } else if (successorParent == current) {

                if (current.getData() < successor.getData()) {
                    current.setRight(successor.getRight());

                } else {
                    current.setRight(successor.getRight());
                    current.setLeft(successor.getLeft());
                }
            } else if (successorParent.getLeft() != null) {
                successorParent.setLeft(null);
            }
            current.setData(successor.getData());
        }

        current.setHeight();
        inOrder(current);
        return current;

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
     * Prints the tree
     */
    public void print() {

        root.printTree();
    }

}
