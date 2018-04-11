package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.p1_height_of_a_binary_tree;

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
        if (newNode.data < currentNode.data) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
                return newNode.height;
            } else {
                currentNode.height = Math.max(insertNode(newNode, currentNode.leftChild),
                                              currentNode.rightChild != null ? currentNode.rightChild.height : 0) + 1;
            }
        } else if (newNode.data > currentNode.data) {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
                return newNode.height;
            } else {
                currentNode.height = Math.max(insertNode(newNode, currentNode.rightChild),
                                              currentNode.leftChild != null ? currentNode.leftChild.height : 0) + 1;
            }
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
