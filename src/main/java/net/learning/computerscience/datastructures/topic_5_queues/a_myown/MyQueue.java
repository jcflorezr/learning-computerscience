package net.learning.computerscience.datastructures.topic_5_queues.a_myown;

public class MyQueue<T> {

    Node<T> root;

    private int size;

    public void offer(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            root.setPrevious(root);
        } else {
            newNode.setNext(root);
            newNode.setPrevious(root.getPrevious());
            root.setPrevious(newNode);
            root = newNode;
        }
        size++;
    }

    public T poll() {
        Node<T> retrievedNode = null;
        if (root != null) {
            retrievedNode = root.getPrevious();
            if (size > 1) {
                root.setPrevious(retrievedNode.getPrevious());
                root.getPrevious().setNext(null);
            } else {
                root = null;
            }
            size--;
        }
        return (retrievedNode == null) ? null : retrievedNode.getData();
    }

    public T peek() {
        return (root == null) ? null : root.getPrevious().getData();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        Node<T> current = root;
        String result = "[";
        while (current != null) {
            result += current + " -> ";
            current = current.getNext();
        }
        result += current + "]";
        return result;
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        private Node<T> previous;

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

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
