package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_AVL_trees.avl_insertion;

public class AVLTree<T extends Comparable<T>> {

    Node<T> root;

    public void insert(T element) {
        Node<T> newNode = new Node<>(element);
        if (root == null) root = newNode;
        else root = insert(root, newNode);
    }

    private Node<T> insert(Node<T> currentNode, Node<T> newNode) {
        if (currentNode == null) return newNode;
        if (currentNode.element.compareTo(newNode.element) > 0) {
            currentNode.left = insert(currentNode.left, newNode);
        } else {
            currentNode.right = insert(currentNode.right, newNode);
        }
        return balance(currentNode);
    }

    private Node<T> balance(Node<T> currentNode) {
        int leftHeight = currentNode.left != null ? currentNode.left.getHeight() : 0;
        int rightHeight = currentNode.right != null ? currentNode.right.getHeight() : 0;
        int balance = Math.abs(leftHeight - rightHeight);
        if (balance > 1) {
            if (leftHeight > rightHeight) {
                Node<T> leftSubtree = currentNode.left;
                int leftSubtreeHeight = leftSubtree.left != null ? leftSubtree.left.getHeight() : 0;
                int rightSubtreeHeight = leftSubtree.right != null ? leftSubtree.right.getHeight() : 0;
                if (leftSubtreeHeight > rightSubtreeHeight) {
                    currentNode = rightRotation(currentNode);
                } else {
                    currentNode.left = leftRotation(leftSubtree);
                    currentNode = rightRotation(currentNode);
                }
            } else {
                Node<T> rightSubtree = currentNode.right;
                int leftSubtreeHeight = rightSubtree.left != null ? rightSubtree.left.getHeight() : 0;
                int rightSubtreeHeight = rightSubtree.right != null ? rightSubtree.right.getHeight() : 0;
                if (rightSubtreeHeight > leftSubtreeHeight) {
                    currentNode = leftRotation(currentNode);
                } else {
                    currentNode.right = rightRotation(rightSubtree);
                    currentNode = leftRotation(currentNode);
                }
            }
        }
        return currentNode;
    }

    private Node<T> leftRotation(Node<T> currentNode) {
        Node<T> tempNode = currentNode.right.left;
        Node<T> currentTemp = currentNode.right;
        currentNode.right.left = currentNode;
        currentNode.right = tempNode;
        return currentTemp;
    }

    private Node<T> rightRotation(Node<T> currentNode) {
        Node<T> tempNode = currentNode.left.right;
        Node<T> currentTemp = currentNode.left;
        currentNode.left.right = currentNode;
        currentNode.left = tempNode;
        return currentTemp;
    }


}

class Node<T>  {
    T element;
    Node<T> left;
    Node<T> right;

    public Node(T element) {
        this.element = element;
    }

    public int getHeight() {
        int leftHeight = left != null ? left.getHeight() : 0;
        int rightHeight = right != null ? right.getHeight() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        return "{" + element + '}';
    }
}
