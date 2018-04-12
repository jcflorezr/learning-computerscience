package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p1_height_of_a_binary_tree;

public class Solution {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree
                .insertNode(new Node(4))
                .insertNode(new Node(7))
                .insertNode(new Node(2))
                .insertNode(new Node(1))
                .insertNode(new Node(3))
                .insertNode(new Node(9))
                .insertNode(new Node(6))
                .insertNode(new Node(8))
                .insertNode(new Node(5));
        System.out.println();
        binaryTree.insertNode(new Node(0));
        System.out.println();
        binaryTree.insertNode(new Node(-1));
        System.out.println();
    }

}

class BinaryTree {

    Node root;

    public BinaryTree insertNode(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            root.height = insertNode(newNode, root);
        }
        return this;
    }

    private int insertNode(Node newNode, Node currentNode) {
        int currentHeight;
        if (newNode.data < currentNode.data) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
                currentHeight = newNode.height;
            } else {
                currentHeight = insertNode(newNode, currentNode.leftChild);
            }
            currentNode.height = Math.max(currentHeight, currentNode.rightChild != null ? currentNode.rightChild.height : 0) + 1;
        } else if (newNode.data > currentNode.data) {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
                currentHeight = newNode.height;
            } else {
                currentHeight = insertNode(newNode, currentNode.rightChild);
            }
            currentNode.height = Math.max(currentHeight, currentNode.leftChild != null ? currentNode.leftChild.height : 0) + 1;
        }
        return currentNode.height;
    }
}

class Node {

    int data;
    int height = 1;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }

}
