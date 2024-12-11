import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        // Allows us to have access to the value and the current node
        return searchHelper(val, this.root);
    }

    public boolean searchHelper(int val, BSTNode current) {
        // If the value is the same as the value of the current node, we found it
        if (val == current.getVal()) {
            return true;
        }
        // If the current node has no children, we know it is a leaf and that we went through
        // Everything without finding the value, so we can return false
        else if (current.getLeft() == null && current.getRight() == null) {
            return false;
        }
        // If the value is less than the current value, go left
        else if (val < current.getVal()) {
            return searchHelper(val, current.getLeft());
        }
        // If the value is more than the current value, go right
        else if (val > current.getVal()) {
            return searchHelper(val, current.getRight());
        }
        else {
            return false;
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder (left, root, right)
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Create a new array list to store the nodes, the make a helper function that allows us
        // Access to the current node and the array
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        getInorderHelper(this.root, arr);
        return arr;
    }

    // Because ArrayLists pass references, we don't need to return the ArrayList because the
    // Original just gets edited so we can return the original in the previous function
    public void getInorderHelper(BSTNode current, ArrayList<BSTNode> arr) {
        // If there is a left child, keep going left
        if (current.getLeft() != null) {
            getInorderHelper(current.getLeft(), arr);
        }
        // Once we hit the leftmost, say where we are
        arr.add(current);
        // Keep going right
        if (current.getRight() != null) {
            getInorderHelper(current.getRight(), arr);
        }
    }

    /**
     * @return ArrayList of BSTNodes in preorder (root, left, right)
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        getPreorderHelper(this.root, arr);
        return arr;
    }

    public void getPreorderHelper(BSTNode current, ArrayList<BSTNode> arr) {
        // Say where we are immediately
        arr.add(current);
        // Then go left until you can't anymore
        if (current.getLeft() != null) {
            getPreorderHelper(current.getLeft(), arr);
        }
        // Then go right until you can't anymore
        if (current.getRight() != null) {
            getPreorderHelper(current.getRight(), arr);
        }
    }

    /**
     * @return ArrayList of BSTNodes in postorder (left, right, root)
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> arr = new ArrayList<BSTNode>();
        getPostorderHelper(this.root, arr);
        return arr;
    }

    public void getPostorderHelper(BSTNode current, ArrayList<BSTNode> arr) {
        // If there is a left child, keep going left
        if (current.getLeft() != null) {
            getPostorderHelper(current.getLeft(), arr);
        }
        // If there is a right child, go right
        if (current.getRight() != null) {
            getPostorderHelper(current.getRight(), arr);
        }
        // Say where we are
        arr.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // If value is not already in the array
        if (!search(val)) {
            // Update the root with the new tree
            this.root = insertHelper(this.root, val);
        }
    }

    public BSTNode insertHelper(BSTNode current, int val) {
        // If where we find the place where we need to be and it doesn't exist, insert val
        if (current == null) {
            return new BSTNode(val);
        }
        // If val is less than where we are, go left
        if (val < current.getVal()) {
            current.setLeft(insertHelper(current.getLeft(), val));
        }
        // If val is more than where we are, go right
        if (val > current.getVal()) {
            current.setRight(insertHelper(current.getRight(), val));
        }
        return current;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
