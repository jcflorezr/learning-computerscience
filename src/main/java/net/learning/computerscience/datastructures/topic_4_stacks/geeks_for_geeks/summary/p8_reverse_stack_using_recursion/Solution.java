package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p8_reverse_stack_using_recursion;

/**
 * https://www.geeksforgeeks.org/?p=6921
 */
public class Solution {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(new int[]{1,2,3,4});
        stack.reverse();
        System.out.println(stack.toString());
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class CustomStack {
    Node head;

    CustomStack(int[] ints) {
        push(ints, ints.length - 1);
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    private void push(int[] ints, int i) {
        if (i < 0) return;
        push(ints[i]);
        push(ints, i - 1);
    }

    @Override
    public String toString() {
        Node temp = head;
        return toString(temp);
    }

    private String toString(Node node) {
        if (node == null) return "";
        return node.data + " -> " + toString(node.next);
    }

    public void reverse() {
        if (head == null) return;
        Node node = pop();
        reverse();
        reverse(node);
    }

    private void reverse(Node node) {
        if (head == null) push(node.data);
        else {
            Node temp = pop();
            reverse(node);
            push(temp.data);
        }
    }

    private Node pop() {
        Node temp = head;
        head = temp != null ? temp.next : temp;
        return temp;
    }
}
