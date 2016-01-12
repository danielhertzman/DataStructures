package assignment3;

/**
 * @author danielhertzman-ericson
 */
public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;
    private int height;

    public TreeNode(int data) {

        this.data = data;
        height = 0;
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

    public void setHeight() {

        int leftHeight;
        int rightHeight;

        leftHeight = left == null ? 0 : left.getHeight();
        rightHeight = right == null ? 0 : right.getHeight();

        height = leftHeight >= rightHeight ? leftHeight + 1: rightHeight + 1;

    }

    public int getDifference() {

        int leftSide;
        int rightSide;

        leftSide = left == null ? 0 : left.getHeight();
        rightSide = right == null ? 0 : right.getHeight();

        return leftSide - rightSide;
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

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(7);
        bt.add(11);
        bt.add(3);
        bt.add(13);
        bt.add(9);
        bt.add(5);
        bt.add(1);
        bt.add(14);
        bt.add(12);
        bt.add(10);
        bt.add(8);
        bt.add(6);
        bt.add(4);
        bt.add(2);
        bt.add(0);
        bt.print();
        bt.delete(11);
        System.out.println("--------------------------");
        bt.print();
        System.out.println("--------------------------");
        bt.delete(14);
        bt.print();
        System.out.println("--------------------------");
        bt.delete(7);
        bt.print();
        System.out.println("--------------------------");
        bt.delete(1);
        bt.print();
        System.out.println("--------------------------");


    }

}
