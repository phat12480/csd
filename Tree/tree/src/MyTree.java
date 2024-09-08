
import java.util.*;
import java.io.*;

class MyTree {

    Node root;

    // Constructor
    MyTree() {
        this.root = null;
    }

    public void load() {
        root = new Node(50);
        root.left = new Node(15);
        root.right = new Node(70);
        root.left.left = new Node(5);
        root.left.right = new Node(40);
        root.right.left = new Node(35);
        root.right.right = new Node(20);
        root.right.right.left = new Node(30);
        root.left.right.left = new Node(60);
        root.left.right.left.right = new Node(100);
    }

    public int f1() {
        return computeHeight(root);
    }

    private int computeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = computeHeight(node.left);
        int rightHeight = computeHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // f2: Count total number of nodes
    public int f2() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // f3: Count leaf nodes
    public int f3() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // f4: Compute sum of all nodes
    public int f4() {
        return computeSum(root);
    }

    private int computeSum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.info + computeSum(node.left) + computeSum(node.right);
    }

    public int f5() {
        return findMax(root);
    }

    private int findMax(Node node) {
        if (node == null) {
            return 0; // Return the smallest possible value if the tree is empty
        }
        int maxLeft = findMax(node.left);
        int maxRight = findMax(node.right);
        return Math.max(node.info, Math.max(maxLeft, maxRight));
    }

    private Node findMax2(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    void deleteByMerging(Department de) {
        root = deleteCopyingRecursiveRMD(root, de);
    }

    private Node deleteMergingRecursiveRMR(Node node, Department de) {
//stop when node == null
        if (node == null) {
            return null;
        }
//node.left if x<node
//        if (de < node.info.getPrice()) {
//            node.left = deleteMergingRecursiveRMR(node.left, de);
//        } else if (de.getPrice() > node.info.getPrice()) {
            node.right = deleteMergingRecursiveRMR(node.right, de);
         {
//x==node 3 TH
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
//delete 2 Child: 
//B1: tim phai cung cua ben trai
//B2: noi cay phai qua cay trai va move root qua trai
                Node rightMost = node.left;
                findMax(rightMost);
                rightMost.right = node.right;
                node = node.left;
            }
        }
        return node;
    }

    private Node deleteMergingRecursiveRML(Node node, Department de) {
        if (node == null) {
            return null;
        }
//        if (de.getPrice() < node.info.getPrice()) {
//            node.left = deleteMergingRecursiveRML(node.left, de);
//        } else if (de.getPrice() > node.info.getPrice()) {
            node.right = deleteMergingRecursiveRML(node.right, de);
         {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node leftMost = node.right;
                findMin(leftMost);
                leftMost.left = node.left;
                node = node.right;
            }
        }
        return node;
    }

    private Node deleteCopyingRecursiveRMD(Node node, Department de) {
        if (node == null) {
            return null;
        }
//        if (de.getPrice() < node.info.getPrice()) {
//            node.left = deleteCopyingRecursiveRMD(node.left, de);
//        } else if (de.getPrice() > node.info.getPrice()) {
            node.right = deleteCopyingRecursiveRMD(node.right, de);
          {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
//delete 2 Child:
//B1: tim phai cung cua ben trai
//B2: gan info phai cung cho nut dau
//B3: xoa info phai cung cua nut trai va xoa righmostinfo ben trai
                Node rightMost = node.left;
                findMax(rightMost);
                node.info = rightMost.info;
//                node.left = deleteCopyingRecursiveRMD(node.left, rightMost.info);
            }
        }
        return node;
    }

    private Node deleteCopyingRecursiveRLD(Node node, Department de) {
        if (node == null) {
            return null;
        }
//        if (de.getPrice() < node.info.getPrice()) {
//            node.left = deleteCopyingRecursiveRLD(node.left, de);
//        } else if (de.getPrice() > node.info.getPrice()) {
            node.right = deleteCopyingRecursiveRLD(node.right, de);
     {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node leftMost = node.right;
                findMin(leftMost);
                node.info = leftMost.info;
//                node.right = deleteCopyingRecursiveRLD(node.right, leftMost.info);
            }
        }
        return node;
    }
}
