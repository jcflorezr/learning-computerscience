package net.learning.computerscience.datastructures.stack.a_myown;

public class MyStack<T> {

    private Node<T> root;
    private int size;

    public MyStack() {
        root = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            newNode.setNext(root);
            root = newNode;
        }
        size++;
    }

    public T pop() {
        Node<T> node = null;
        if (root != null) {
            node = root;
            root = node.getNext();
            node.setNext(null);
            size--;
        }
        return node != null ? node.getData() : null;
    }

    public T peek() {
        Node<T> node = null;
        if (root != null) {
            node = root;
        }
        return (node != null) ? node.getData() : null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> head = root;
        String result = "[";
        while (head != null) {
            result += head + " -> ";
            head = head.next;
        }
        result += head + "]";
        return result;
    }

    private class Node <T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
