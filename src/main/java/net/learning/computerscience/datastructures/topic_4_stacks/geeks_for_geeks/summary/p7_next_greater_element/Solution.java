package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p7_next_greater_element;

/**
 * https://www.geeksforgeeks.org/?p=8405
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {13,7,6,12};
        findNextGreaters(ints);
        System.out.println("===================");
        ints = new int[]{5,3,2,10,6,8,1,4,12,7,4};
        findNextGreaters(ints);
    }

    private static void findNextGreaters(int[] ints) {
        CustomStack<Integer> auxStack = new CustomStack<>();
        for (Integer in : ints) {
            while (auxStack.peek() != null && in > auxStack.peek().data) {
                System.out.println(auxStack.pop().data + " -- " + in);
            }
            auxStack.push(in);
        }
        while (auxStack.peek() != null) {
            System.out.println(auxStack.pop().data + " -- " + -1);
        }
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

    void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    Node<T> pop() {
        Node temp = head;
        head = temp != null ? temp.next : temp;
        return temp;
    }

    Node<T> peek() {
        return head;
    }

}