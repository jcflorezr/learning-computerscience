package net.learning.computerscience.datastructures.linkedlist.a_myown;

public class SinglyLinkedList <T> {

    Node<T> root;

    public SinglyLinkedList() {
        this.root = null;
    }

    // O(1)
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node newNode = new Node(data);
            newNode.setNext(root);
            root = newNode;
        }
    }

    // O(n)
    public void insertAtLast(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<T> currentNode = root;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<>(data));
        }
    }

    // O(1). As stack (LIFO)
    public void remove() {
        if (root != null) {
            root = root.getNext();
        }
    }

    // O(n). As queue (FIFO)
    public void removeAtLast() {
        if (root != null) {
            Node<T> currentNode = root;
            Node<T> previousNode = null;
            while (currentNode.getNext() != null) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            previousNode.setNext(null);
            currentNode = null; // remove the last reference to the object
        }
    }

    // O(n)
    public void remove(T data) {
        if (root != null) {
            Node<T> currentNode = root;
            Node<T> previousNode = null;
            while (!currentNode.getData().equals(data)) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if (previousNode != null) {
                previousNode.setNext(currentNode.getNext());
            } else {
                root = currentNode.getNext();
                currentNode = null;
            }
        }
    }

    @Override
    public String toString() {
        String result = "[";
        while (root != null) {
            result += root.getData() + " -> ";
            root = root.getNext();
        }
        result += "null]";
        return result;
    }
}

class Node<T> {

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
}
