package net.learning.computerscience.datastructures.trees.course.redblacktree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void traverse() {
        if (root != null) {
            inOrderTraversal(root);
        }
    }

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        root = insertNode(root, newNode);
        settleViolation(newNode);
    }

    private void settleViolation(Node<T> node) {
        Node<T> parentNode = null;
        Node<T> grandParentNode = null;

        while (node != root && node.getNodeColor() != NodeColor.BLACK && node.getParent().getNodeColor() == NodeColor.RED) {
            parentNode = node.getParent();
            grandParentNode = parentNode.getParent();

            if (parentNode == grandParentNode.getLeftChildNode()) {
                Node<T> uncle = grandParentNode.getRightChildNode();
                if (uncle != null && uncle.getNodeColor() == NodeColor.RED) {
                    grandParentNode.setNodeColor(NodeColor.RED);
                    parentNode.setNodeColor(NodeColor.BLACK);
                    uncle.setNodeColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    if (node == parentNode.getRightChildNode()) {
                        leftRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    rightRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getNodeColor();
                    parentNode.setNodeColor(grandParentNode.getNodeColor());
                    grandParentNode.setNodeColor(tempColor);
                    node = parentNode;
                }
            } else {
                Node<T> uncle = grandParentNode.getLeftChildNode();

                if (uncle != null && uncle.getNodeColor() == NodeColor.RED) {
                    grandParentNode.setNodeColor(NodeColor.RED);
                    parentNode.setNodeColor(NodeColor.BLACK);
                    uncle.setNodeColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    if (node == parentNode.getLeftChildNode()) {
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }

                    leftRotation(grandParentNode);
                    NodeColor tempColor = parentNode.getNodeColor();
                    parentNode.setNodeColor(grandParentNode.getNodeColor());
                    grandParentNode.setNodeColor(tempColor);
                    node = parentNode;
                }
            }
        }

        if (root.getNodeColor() == NodeColor.RED) {
            root.setNodeColor(NodeColor.BLACK);
        }
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChildNode() != null) {
            inOrderTraversal(node.getLeftChildNode());
        }

        System.out.println(node + " - ");

        if (node.getRightChildNode() != null) {
            inOrderTraversal(node.getRightChildNode());
        }
    }

    private Node<T> insertNode(Node<T> root, Node<T> node) {

        if (root == null) return node;

        if (node.getData().compareTo(root.getData()) < 0) {
            root.setLeftChildNode(insertNode(root.getLeftChildNode(), node));
            root.getLeftChildNode().setParent(root);
        } else if (node.getData().compareTo(root.getData()) > 0) {
            root.setRightChildNode(insertNode(root.getRightChildNode(), node));
            root.getRightChildNode().setParent(root);
        }

        return root;
    }

    private void rightRotation(Node<T> node) {
        System.out.println("Rotating to the right on Node: " + node);

        Node<T> tempLeftNode = node.getLeftChildNode();
        if (node.getLeftChildNode() != null) {
            node.getLeftChildNode().setParent(node);
        }

        tempLeftNode.setParent(node.getParent());

        if (tempLeftNode.getParent() == null) {
            root = tempLeftNode;
        } else if (node == node.getParent().getLeftChildNode()) {
            node.getParent().setLeftChildNode(tempLeftNode);
        } else {
            node.getParent().setRightChildNode(tempLeftNode);
        }

        tempLeftNode.setRightChildNode(node);
        node.setParent(tempLeftNode);
    }

    private void leftRotation(Node<T> node) {
        System.out.println("Rotating to the left on Node: " + node);

        Node<T> tempRightNode = node.getRightChildNode();
        if (node.getRightChildNode() != null) {
            node.getRightChildNode().setParent(node);
        }

        tempRightNode.setParent(node.getParent());

        if (tempRightNode.getParent() == null) {
            root = tempRightNode;
        } else if (node == node.getParent().getLeftChildNode()) {
            node.getParent().setLeftChildNode(tempRightNode);
        } else {
            node.getParent().setRightChildNode(tempRightNode);
        }

        tempRightNode.setLeftChildNode(node);
        node.setParent(tempRightNode);
    }

}
