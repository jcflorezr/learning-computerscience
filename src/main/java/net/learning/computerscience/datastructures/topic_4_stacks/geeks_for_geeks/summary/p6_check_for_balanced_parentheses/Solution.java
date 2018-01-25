package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p6_check_for_balanced_parentheses;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/?p=6547
 */
public class Solution {

    private static Map<String, String> pairs = new HashMap<>();

    static {
        pairs.put(")", "(");
        pairs.put("}", "{");
        pairs.put("]", "[");
    }

    public static void main(String[] args) {
        CustomStack<String> stack = new CustomStack<>("[()]{}{[()()]()}".split(""));
        System.out.println(isBalanced(stack));
        stack = new CustomStack<>("[(])".split(""));
        System.out.println(isBalanced(stack));
    }

    private static boolean isBalanced(CustomStack<String> stack) {
        Node<String> current = stack.peek();
        CustomStack<String> auxiliarStack = new CustomStack<>();
        auxiliarStack.push(current.data);
        while (current != null) {
            String s = pairs.get(current.data);
            if (s != null) {
                if (!auxiliarStack.peek().data.equals(s)) return false;
                auxiliarStack.pop();
            } else {
                auxiliarStack.push(current.data);
            }
            current = stack.pop();
        }
        return true;
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

    public CustomStack(T[] values) {
        push(values, values.length - 1);
    }

    private void push(T[] values, int i) {
        if (i < 0) return;
        push(values[i]);
        push(values, i - 1);
    }

    void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }

    Node<T> pop() {
        Node<T> temp = head;
        head = temp != null ? temp.next : temp;
        return head;
    }

    public Node<T> peek() {
        return head;
    }
}
