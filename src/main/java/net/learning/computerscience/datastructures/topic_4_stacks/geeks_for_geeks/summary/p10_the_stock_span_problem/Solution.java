package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p10_the_stock_span_problem;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class Solution {

    public static void main(String[] args) {
        int[] stocksArray = new int[] {7,5,2,3,2,4,6};
        System.out.println(Arrays.toString(getSpans(stocksArray)));
    }

    private static int[] getSpans(int[] stocks) {
        CustomStack stack = new CustomStack();
        int[] spansArray = new int[stocks.length];
        stack.push(0);
        spansArray[0] = 1;
        for (int i = 1; i < stocks.length; i++) {
            while (!stack.isEmpty() && stocks[stack.peek().data] <= stocks[i])
                stack.pop();
            spansArray[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek().data);
            stack.push(i);
        }
        return spansArray;
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

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    Node pop() {
        Node temp = head;
        head = temp != null ? temp.next : temp;
        return temp;
    }

    Node peek() {
        Node temp = head;
        return temp;
    }

    boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        String l = "";
        Node temp = head;
        while (temp != null) {
            l += temp.data + " -> ";
            temp = temp.next;
        }
        return l;
    }
}