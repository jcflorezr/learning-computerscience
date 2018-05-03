package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p18_my_own_avl_tree;

public class SolutionV2 {

    public AVLTree getTree(int[] elements) {
        AVLTree tree = new AVLTree();
        for (int element : elements) {
            tree.insertNode(new AugmentedNode(element));
        }
        return tree;
    }

}

class AugmentedNode {
    int data;
    AugmentedNode leftChild;
    AugmentedNode rightChild;
    int leftChildHeight;
    int rightChildHeight;

    public AugmentedNode(int data) {
        this.data = data;
    }

    int getHeight() {
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }
}

class AVLTree {
    AugmentedNode root;

    public void insertNode(AugmentedNode newNode) {
        if (root == null) root = newNode;
        else insertNode(newNode, root);
    }

    private int insertNode(AugmentedNode newNode, AugmentedNode currentNode) {
        if (newNode.data <= currentNode.data) {
            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
                currentNode.leftChildHeight = newNode.getHeight();
            } else {
                currentNode.leftChildHeight = insertNode(newNode, currentNode.leftChild);
            }
            return currentNode.getHeight();
        } else {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
                currentNode.rightChildHeight = newNode.getHeight();
            } else {
                currentNode.rightChildHeight = insertNode(newNode, currentNode.rightChild);
            }
            return currentNode.getHeight();
        }
    }
}