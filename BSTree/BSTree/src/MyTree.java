
import java.util.*;
import java.io.*;

class MyTree {

    Node root;

    MyTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node p, int value) {
        if (p == null) {
            p = new Node(value);
        } else if (value < p.info) {
            p.left = insertRec(p.left, value);
        } else if (value > p.info) {
            p.right = insertRec(p.right, value);
        }
        return p;
    }

    public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);

    }

    int search(Node p, int x) {
        if (p == null) {
            return 0;
        }
        if (p.info == x) {
            return 1;
        }
        if (x < p.info) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    public int f1() {
        return 0;
    }

    public int f2() {
        return 0;
    }

    public int f3() {
        return 0;
    }

    public int f4() {
        return 0;
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void f5() {
        preOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void f6() {
        inOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void f7() {
        postOrder(root);
    }

    int f8(int n) {
        return search(root, n);
    }

    void f9() {
        inOrder2(root);
    }

    void inOrder2(Node p) {
        if (p == null) {
            return;
        }
        inOrder2(p.left);
        if (p.info % 2 == 0) {
            visit(p);
        }
        inOrder2(p.right);
    }

    /**
     * Rotate binary tree node with left child. For AVL trees, this is a single
     * rotation for case 1.
     */
    public Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * Rotate binary tree node with right child. For AVL trees, this is a single
     * rotation for case 4.
     */
    public Node rotateWithRightChild(Node k1) {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child with its right child;
     * then node k3 with new left child. For AVL trees, this is a double
     * rotation for case 2.
     */
    public Node doubleRotateWithLeftChild(Node k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child with its left child;
     * then node k1 with new right child. For AVL trees, this is a double
     * rotation for case 3.
     */
    public Node doubleRotateWithRightChild(Node k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    public void insertAtPosition(Node parent, int value, boolean asLeftChild) {
        Node newNode = new Node(value);
        if (parent == null) {
            System.out.println("Parent node is null, cannot insert.");
            return;
        }

        if (asLeftChild) {
            if (parent.left == null) {
                parent.left = newNode;
            } else {
                System.out.println("Left child already exists. Overwriting the node.");
                parent.left = newNode;
            }
        } else {
            if (parent.right == null) {
                parent.right = newNode;
            } else {
                System.out.println("Right child already exists. Overwriting the node.");
                parent.right = newNode;
            }
        }
    }

    public void insertAtPosition(Node current, int value, int parentValue, boolean asLeftChild) {
        if (current == null) {
            System.out.println("Parent node not found, cannot insert.");
            return;
        }

        // If the current node matches the parent value, insert the new node
        if (current.info == parentValue) {
            if (asLeftChild) {
                if (current.left == null) {
                    current.left = new Node(value);
                    System.out.println("Inserted " + value + " as left child of " + parentValue);
                } else {
                    System.out.println("Left child already exists for node " + parentValue + ". Overwriting the node.");
                    current.left = new Node(value);
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(value);
                    System.out.println("Inserted " + value + " as right child of " + parentValue);
                } else {
                    System.out.println("Right child already exists for node " + parentValue + ". Overwriting the node.");
                    current.right = new Node(value);
                }
            }
            return;
        }

        // Recursively traverse the left and right subtrees
        insertAtPosition(current.left, value, parentValue, asLeftChild);
        insertAtPosition(current.right, value, parentValue, asLeftChild);
    }
}
