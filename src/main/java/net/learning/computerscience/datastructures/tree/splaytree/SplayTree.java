package net.learning.computerscience.datastructures.tree.splaytree;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private int size;
    private Node<T> rootNode;

    @Override
    public void insert(T data) {

        Node<T> tempNode = this.rootNode;
        Node<T> parentNode = null;

        while (tempNode != null) {

            parentNode = tempNode;

            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightChildNode();
            } else {
                tempNode = tempNode.getLeftChildNode();
            }
        }

        tempNode = new Node<>(data);
        tempNode.setParentNode(parentNode);

        if (parentNode == null) {
            this.rootNode = tempNode;
        } else if (parentNode.getData().compareTo(tempNode.getData()) < 0) {
            parentNode.setRightChildNode(tempNode);
        } else {
            parentNode.setLeftChildNode(tempNode);
        }

        splay(tempNode);
        this.size++;
    }

    @Override
    public void inOrderTraversal() {
        if (this.rootNode != null) {
            inOrderTraversal(rootNode);
        }
    }

    private void inOrderTraversal(Node<T> node) {

        if (node.getLeftChildNode() != null) {
            inOrderTraversal(node.getLeftChildNode());
        }

        System.out.print(node + " ");

        if (node.getRightChildNode() != null) {
            inOrderTraversal(node.getRightChildNode());
        }
    }

    @Override
    public T getMin() {
        if (this.rootNode != null) {
            return getMin(rootNode);
        }

        return null;
    }

    private T getMin(Node<T> node) {

        if (node.getLeftChildNode() != null) {
            return getMin(node.getLeftChildNode());
        } else {
            return node.getData();
        }
    }

    @Override
    public T getMax() {
        if (this.rootNode != null) {
            return getMax(rootNode);
        }

        return null;
    }

    private T getMax(Node<T> node) {

        if (node.getRightChildNode() != null) {
            return getMax(node.getRightChildNode());
        } else {
            return node.getData();
        }
    }

    public void printRoot() {
        System.out.println(rootNode);
    }

    public boolean isEmpty() {
        return this.rootNode == null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Node<T> find(T data) {

        Node<T> tempNode = this.rootNode;

        while (tempNode != null) {
            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightChildNode();
            } else if (tempNode.getData().compareTo(data) > 0) {
                tempNode = tempNode.getLeftChildNode();
            } else {
                splay(tempNode);
                return tempNode;
            }
        }

        splay(tempNode);

        return null;
    }

    private void rotateLeft(Node<T> node) {

        Node<T> tempNode = node.getRightChildNode();

        if (tempNode != null) {

            node.setRightChildNode(tempNode.getLeftChildNode());

            if (tempNode.getLeftChildNode() != null) {
                tempNode.getLeftChildNode().setParentNode(node);
            }

            tempNode.setParentNode(node.getParentNode());
        }

        if (node.getParentNode() == null) {
            this.rootNode = tempNode;
        } else if (node == node.getParentNode().getLeftChildNode()) {
            node.getParentNode().setLeftChildNode(tempNode);
        } else {
            node.getParentNode().setRightChildNode(tempNode);
        }

        if (tempNode != null) {
            tempNode.setLeftChildNode(node);
        }

        node.setParentNode(tempNode);
    }

    private void rotateRight(Node<T> node) {

        Node<T> tempNode = node.getLeftChildNode();

        if (tempNode != null) {
            node.setLeftChildNode(tempNode.getRightChildNode());

            if (tempNode.getRightChildNode() != null) {
                tempNode.getRightChildNode().setParentNode(node);
            }

            tempNode.setParentNode(node.getParentNode());
        }

        if (node.getParentNode() == null) {
            this.rootNode = tempNode;
        } else if (node == node.getParentNode().getLeftChildNode()) {
            node.getParentNode().setLeftChildNode(tempNode);
        } else {
            node.getParentNode().setRightChildNode(tempNode);
        }

        if (tempNode != null) {
            tempNode.setRightChildNode(node);
        }

        node.setParentNode(tempNode);
    }

    private void splay(Node<T> node) {

        while (node.getParentNode() != null) {

            // ZIG
            if (node.getParentNode().getParentNode() == null) {
                if (node.getParentNode().getLeftChildNode() == node) {
                    rotateRight(node.getParentNode());
                } else {
                    rotateLeft(node.getParentNode());
                }

            // ZIG-ZIG
            } else if (node.getParentNode().getLeftChildNode() == node
                    && node.getParentNode().getParentNode().getLeftChildNode() == node.getParentNode()) {
                rotateRight(node.getParentNode().getParentNode());
                rotateRight(node.getParentNode());
            } else if (node.getParentNode().getRightChildNode() == node
                    && node.getParentNode().getParentNode().getRightChildNode() == node.getParentNode()) {
                rotateLeft(node.getParentNode().getParentNode());
                rotateLeft(node.getParentNode());

            //ZIG-ZAG
            } else if (node.getParentNode().getLeftChildNode() == node
                    && node.getParentNode().getParentNode().getRightChildNode() == node.getParentNode()) {
                rotateRight(node.getParentNode());
                rotateLeft(node.getParentNode());
            } else {
                rotateLeft(node.getParentNode());
                rotateRight(node.getParentNode());
            }
        }
    }
}
