package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p18_my_own_avl_tree;

public class SolutionV1 {

    public Tree getTree(int[] elements) {

        Tree tree = new Tree();
        for (int element : elements) {
            tree.insertNode(new Node(element));
        }

        return tree;

    }

}

class Tree {
    Node root;

    public void insertNode(Node newNode) {
        if (root == null) root = newNode;
        else insertNode(newNode, root);
    }

    private void insertNode(Node newNode, Node currentNode) {
        if (newNode.data <= currentNode.data) {
            if (currentNode.leftChild == null) currentNode.leftChild = newNode;
            else insertNode(newNode, currentNode.leftChild);
        } else {
            if (currentNode.rightChild == null) currentNode.rightChild = newNode;
            else insertNode(newNode, currentNode.rightChild);
        }
    }

    public int getHeight() {
        if (root == null) return 0;
        return getHeight(root);
    }

    private int getHeight(Node currentNode) {
        if (currentNode == null) return 0;
        return Math.max(getHeight(currentNode.leftChild), getHeight(currentNode.rightChild)) + 1;
    }
}

class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }
}
