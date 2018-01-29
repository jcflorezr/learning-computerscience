package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p11_special_stack_to_get_min_value;

/**
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = new int[] {16,15,29,19,18};
        CustomStack stack = new CustomStack();
        for (int i = ints.length - 1; i >= 0; i--) {
            stack.push(ints[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.getMin());
        }

        ints = new int[] {30,20,10};
        stack = new CustomStack();
        for (int i = ints.length - 1; i >= 0; i--) {
            stack.push(ints[i]);
        }
        System.out.println(stack.getMin());
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.println(stack.getMin());
        }
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}

class CustomStack {

    private Node head;
    private CustomStack auxiliarStack;

    void push(int data) {
        Node newNode = new Node(data);
        Node newAuxNode = newNode;
        if (isEmpty()) {
            auxiliarStack = new CustomStack();
        } else if (newNode.data > auxiliarStack.peek().data) {
            newAuxNode = new Node(auxiliarStack.peek().data);
        }
        push(newNode);
        auxiliarStack.push(newAuxNode);
    }

    private void push(Node node) {
        node.next = head;
        head = node;
    }

    Node pop() {
        Node temp = head;
        head = temp != null ? temp.next : temp;
        return temp;
    }

    Node peek() {
        return new Node(head.data);
    }

    Node getMin() {
        if (isEmpty()) return null;
        Node head = pop();
        Node auxHead = auxiliarStack.pop();
        return (head.data == auxHead.data) ? head : getMin();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
