package net.learning.computerscience.datastructures.topic_6_trees.course.avltree;

public class Node<T> {

    private T data;
    private Node<T> leftChildNode;
    private Node<T> rightChildNode;
    private int height;

    public Node(T data) {
        this.data = data;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
