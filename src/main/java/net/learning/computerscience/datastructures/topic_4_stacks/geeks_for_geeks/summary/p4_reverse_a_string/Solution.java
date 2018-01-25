package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p4_reverse_a_string;

/**
 * https://www.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/
 */
public class Solution {

    public static void main(String[] args) {
        CustomStack<String> stack = new CustomStack<>("hello".split(""));
        System.out.println(stack.getPrintedStack());
    }

}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

class CustomStack<T> {
    Node<T> head;

    public CustomStack() { }

    CustomStack(T[] values) {
        push(values, 0);
    }

    void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    private void push(T[] values, int i) {
        if (i == values.length) return;
        push(values[i]);
        push(values, i + 1);
    }

    Node<T> pop() {
        Node<T> temp = head;
        head = temp != null ? temp.next : temp;
        return temp;
    }

    String getPrintedStack() {
        String l = "";
        Node<T> temp = pop();
        while (temp != null) {
            l += temp.data;
            temp = pop();
        }
        return l;
    }
}
