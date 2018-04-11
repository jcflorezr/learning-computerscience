package net.learning.computerscience.datastructures.topic_6_trees.course.splaytree;

public class Node<T> {

    private T data;
    private Node<T> parentNode;
    private Node<T> leftChildNode;
    private Node<T> rightChildNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
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

    @Override
    public String toString() {
        return this.data.toString();
    }
}
