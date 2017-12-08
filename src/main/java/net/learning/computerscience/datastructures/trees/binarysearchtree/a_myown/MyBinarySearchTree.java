package net.learning.computerscience.datastructures.trees.binarysearchtree.a_myown;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private Queue<T> traversedTree;

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insert(root, data);
        }
    }

    private Node insert(Node<T> node, T data) {
        if (node != null) {
            if (data.compareTo(node.getData()) <= 0) {
                node.setLeftChild(insert(node.getLeftChild(), data));
                return node;
            } else {
                node.setRightChild(insert(node.getRightChild(), data));
                return node;
            }
        } else {
            return new Node<>(data);
        }
    }

    public Queue<T> inOrderTraversal() {
         traversedTree = new LinkedList<>();
        if (root != null) {
            inOrderTraversal(root);
        }
        return traversedTree;
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }
        traversedTree.offer(node.getData());
        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    public Queue<T> preOrderTraversal() {
        traversedTree = new LinkedList<>();
        if (root != null) {
            preOrderTraversal(root);
        }
        return traversedTree;
    }

    public void preOrderTraversal(Node<T> node) {
        traversedTree.offer(node.getData());
        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    public Queue<T> postOrderTraversal() {
        traversedTree = new LinkedList<>();
        if (root != null) {
            postOrderTraversal(root);
        }
        return traversedTree;
    }

    public void postOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            postOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            postOrderTraversal(node.getRightChild());
        }
        traversedTree.offer(node.getData());
    }

    public T getMax() {
        if (root != null) {
            return getMax(root);
        } else {
            return null;
        }
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        } else {
            return node.getData();
        }
    }

    public T getMin() {
        if (root != null) {
            return getMin(root);
        } else {
            return null;
        }
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        } else {
            return node.getData();
        }
    }

    public void remove(T data) {
        if (root != null) {
            remove(root, data);
        }
    }

    private Node<T> remove(Node<T> node, T data) {

        if (node == null) return node;

        if (node.getData().compareTo(data) > 0) {
            node.setLeftChild(remove(node.getLeftChild(), data));
        } else if (node.getData().compareTo(data) < 0) {
            node.setRightChild(remove(node.getRightChild(), data));
        } else {

            // removing a leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                return null;
            }

            // removing a node with one child
            if (node.getRightChild() == null) {
                return node.getLeftChild();
            } else if (node.getLeftChild() == null){
                return node.getRightChild();
            }

            // removing a node with two children
            Node<T> temp = getPredecessor(node.getLeftChild());
            node.setData(temp.getData());
            node.setLeftChild(remove(node.getLeftChild(), temp.getData()));

        }

        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }

        return node;
    }

}
