package net.learning.computerscience.datastructures.topic_3_linkedlists.course.a_myown;

public class DoublyLinkedList <T> {

    private Node<T> root;

    // O(1)
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            root.setPrevious(root);
        } else {
            Node last = root.getPrevious();
            newNode.setNext(root);
            newNode.setPrevious(last);
            root.setPrevious(newNode);
            root = newNode;
        }
    }

    // O(1)
    public void insertAtLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            root.setPrevious(root);
        } else  {
            Node<T> last = root.getPrevious();
            last.setNext(newNode);
            newNode.setPrevious(last);
            root.setPrevious(newNode);
        }
    }

    @Override
    public String toString() {
        String result = "[";
        if (root != null) {
            Node<T> currentNode = root;
            while (currentNode != null) {
                result += currentNode + " <-> " ;
                currentNode = currentNode.getNext();
            }
            result += currentNode;
        }
        result += "]";
        return result;
    }

    // O(1)
    public void remove() {
        if (root != null) {
            Node<T> last = root.getPrevious();
            root = root.getNext();
            root.setPrevious(last);
        }
    }

    // O(1)
    public void removeLast() {
        if (root != null) {
            Node<T> last = root.getPrevious();
            root.setPrevious(last.getPrevious());
            root.getPrevious().setNext(null);
        }
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
