package net.learning.computerscience.datastructures.topic_4_stacks.geeks_for_geeks.summary.p9_sort_stack_using_recursion;

/**
 * https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 */
public class Solution {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(new int[] {-3,14,18,-5,30});
        stack.sort();
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

    public CustomStack(int[] ints) {
        push(ints, ints.length - 1);
    }

    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    private void push(int[] ints, int i) {
        if (i >= 0) {
            push(ints[i]);
            push(ints, i - 1);
        }
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

    void sort() {
        if (head == null) return;
        Node temp = pop();
        sort();
        sort(temp);
    }

    private void sort(Node node) {
        if (head == null || node.data < peek().data) push(node.data);
        else {
            Node greater = pop();
            sort(node);
            push(greater.data);
        }
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