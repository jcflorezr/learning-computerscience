package net.learning.computerscience.datastructures.trees.course.avltree.a_myown;

public class Node<T> {

    private T data;
    private int height;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setHeight() {
        int leftHeight = (this.leftNode == null) ? -1 : this.leftNode.getHeight();
        int rightHeight = (this.rightNode == null) ? -1 : this.rightNode.getHeight();
        height = Math.max(leftHeight, rightHeight) + 1;
    }

    public int getHeight() {
        return height;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }
}
