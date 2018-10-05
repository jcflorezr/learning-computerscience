package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p11_lowest_common_ancestor;

public class Solution {

    public static int lowestCommonAncestor(int[] elements, int a, int b) {
        Tree tree = new Tree();
        for (int element : elements) {
            tree.insert(element);
        }
        Node ancestor = getLowestCommonAncestor(tree.root, a, b);
        return ancestor != null ? ancestor.data : Integer.MIN_VALUE;
    }

    private static Node getLowestCommonAncestor(Node current, int a, int b) {
        if (current == null) return null;
        if (current.data == a || current.data == b) return current;
        Node firstNode = getLowestCommonAncestor(current.left, a, b);
        Node secondNode = getLowestCommonAncestor(current.right, a, b);
        if (firstNode != null && secondNode != null) {
            return current;
        } else {
            return firstNode != null ? firstNode : secondNode;
        }
    }

}

class Tree {
    Node root;

    public void insert(int data) {
        if (root == null) root = new Node(data);
        else root = insert(data, root);
    }

    private Node insert(int data, Node current) {
        if (current == null) return new Node(data);
        if (current.data > data) {
            current.left = insert(data, current.left);
        } else {
            current.right = insert(data, current.right);
        }
        return current;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
