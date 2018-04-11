package net.learning.computerscience.datastructures.topic_6_trees.course.redblacktree;

public class Node<T> {

    private T data;
    private Node<T> leftChildNode;
    private Node<T> rightChildNode;
    private Node<T> parent;
    private NodeColor nodeColor;

    public Node(T data) {
        this.data = data;
        this.nodeColor = NodeColor.RED;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node<T> leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Node<T> getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node<T> rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public NodeColor getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(NodeColor nodeColor) {
        this.nodeColor = nodeColor;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
