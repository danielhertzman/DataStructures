package assignment3;

/**
 * Class that represent a single node in a binary tree
 *
 * @author danielhertzman-ericson
 */
public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;
    private int height;
    private int leftHeight;
    private int rightHeight;

    public TreeNode(int data) {

        this.data = data;

    }

    public void setData(int data) {

        this.data = data;
    }

    public void setLeft(TreeNode left) {

        this.left = left;
    }

    public void setRight(TreeNode right) {

        this.right = right;
    }

    public int getData() {

        return data;
    }

    public TreeNode getLeft() {

        return left;
    }

    public TreeNode getRight() {

        return right;
    }

    public int getHeight() {

        return height;
    }

    /**
     * Sets the height of the tree by calculating the height
     * of left and right side. The one that is highest sets the height
     * of the tree
     */
    public void setHeight() {

        leftHeight = left == null ? 0 : left.getHeight();
        rightHeight = right == null ? 0 : right.getHeight();

        height = leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;

    }

    /**
     * Returns the difference between the left and right height
     * @return
     */
    public int getDifference() {

        leftHeight = left == null ? 0 : left.getHeight();
        rightHeight = right == null ? 0 : right.getHeight();

        return leftHeight - rightHeight;
    }


    //----------------------------Print methods and main--------------------------------

    public void printTree() {

        if (this.right != null) {
            right.printTree(true, "");
        }

        printNodeValue();
        if (left != null) {
            left.printTree(false, "");
        }
    }


    private void printTree(boolean isRight, String indent) {
        if (right != null) {
            right.printTree(true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue();
        if (left != null) {
            left.printTree(false, indent + (isRight ? " |      " : "        "));
        }
    }

    private void printNodeValue() {
        System.out.print(data);
        System.out.print('\n');
    }

    /*
    Compare the result from BinaryTree and AVLTree
     */
//    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
////        AVLTree tree = new AVLTree();
//
//        tree.add(7);
//        tree.add(11);
//        tree.add(3);
//        tree.add(13);
//        tree.add(9);
//        tree.add(5);
//        tree.add(1);
//        tree.add(14);
//        tree.add(12);
//        tree.add(10);
//        tree.add(8);
//        tree.add(6);
//        tree.add(4);
//        tree.add(2);
//        tree.add(0);
//        tree.print();
//        tree.delete(11);
//        System.out.println("--------------------------");
//        tree.print();
//        System.out.println("--------------------------");
//        tree.delete(14);
//        tree.print();
//        System.out.println("--------------------------");
//        tree.delete(7);
//        tree.print();
//        System.out.println("--------------------------");
//        tree.delete(1);
//        tree.print();
//        System.out.println("--------------------------");
//        tree.delete(3);
//        tree.print();
//        System.out.println("--------------------------");
//        tree.delete(5);
//        tree.print();
//        System.out.println("--------------------------");
//        tree.delete(12);
//        tree.print();
//
//    }



    public static void main(String...args) {
        AVLTree t = new AVLTree();
        t.add(50); t.add(60); t.add(40); t.add(30); t.add(20); t.add(70); t.add(25);
        t.delete(30);
        t.print();
    }

}