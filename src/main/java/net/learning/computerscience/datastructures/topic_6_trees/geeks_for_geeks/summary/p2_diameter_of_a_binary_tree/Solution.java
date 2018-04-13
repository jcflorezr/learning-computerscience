package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p2_diameter_of_a_binary_tree;

/**
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class Solution {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(new Node(7))
                    .insertNode(new Node(-1))
                    .insertNode(new Node(4))
                    .insertNode(new Node(8))
                    .insertNode(new Node(2))
                    .insertNode(new Node(9))
                    .insertNode(new Node(6))
                    .insertNode(new Node(1))
                    .insertNode(new Node(0));
        binaryTree.insertNode(new Node(3));
        System.out.println();

        binaryTree = new BinaryTree();
        binaryTree
                .insertNode(new Node(70))
                .insertNode(new Node(40))
                .insertNode(new Node(80))
                .insertNode(new Node(30))
                .insertNode(new Node(75))
                .insertNode(new Node(85))
                .insertNode(new Node(50))
                .insertNode(new Node(20))
                .insertNode(new Node(60))
                .insertNode(new Node(35))
                .insertNode(new Node(25))
                .insertNode(new Node(65))
                .insertNode(new Node(10))
                .insertNode(new Node(55));

    }

}

class BinaryTree {

    Node root;

    public BinaryTree insertNode(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            root.height = insertNode(newNode, root);
            setDiameters(root);
        }
        return this;
    }

    private int insertNode(Node newNode, Node currentNode) {
        int currentHeight = -1;
        Node siblingNode = null;
        if (newNode.data < currentNode.data) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
                currentHeight = newNode.height;
            } else {
                currentHeight = insertNode(newNode, currentNode.leftChild);
            }
            siblingNode = currentNode.rightChild;
        } else if (newNode.data > currentNode.data) {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
                currentHeight = newNode.height;
            } else {
                currentHeight = insertNode(newNode, currentNode.rightChild);
            }
            siblingNode = currentNode.leftChild;
        }

        currentNode.height = Math.max(currentHeight, siblingNode != null ? siblingNode.height : 0) + 1;
        return currentNode.height;
    }

    private int setDiameters(Node node) {
        if (node == null) return 0;
        int leftDiameter = setDiameters(node.leftChild);
        int rightDiameter = setDiameters(node.rightChild);
        int leftHeight = node.leftChild != null ? node.leftChild.height : 0;
        int rightHeight = node.rightChild != null ? node.rightChild.height : 0;
        node.diameter = Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
        return node.diameter;
    }

}

class Node {
    int data;
    int height = 1;
    int diameter;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }
}
