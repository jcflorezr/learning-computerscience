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

    public boolean deleteNode(int data) {
        AugmentedNode nodeToBeDeleted = getNodeToBeDeleted(root, data);
        if (nodeToBeDeleted == null) return false;
        int numOfChildren = checkNumOfChildren(nodeToBeDeleted);
        switch (numOfChildren) {
            case 0:
                return deleteLeafNode(nodeToBeDeleted);
        }
        return false;
    }

    private boolean deleteLeafNode(AugmentedNode nodeToBeDeleted) {

        return false;
    }

    private int checkNumOfChildren(AugmentedNode nodeToBeDeleted) {
        return (nodeToBeDeleted.leftChild == null ? 0 : 1) + (nodeToBeDeleted.rightChild == null ? 0 : 1);
    }

    private AugmentedNode getNodeToBeDeleted(AugmentedNode currentNode, int data) {
        if (currentNode == null) return null;
        if (currentNode.data == data) return currentNode;
        if (data < currentNode.data) return getNodeToBeDeleted(currentNode.leftChild, data);
        else return getNodeToBeDeleted(currentNode.rightChild, data);
    }
}