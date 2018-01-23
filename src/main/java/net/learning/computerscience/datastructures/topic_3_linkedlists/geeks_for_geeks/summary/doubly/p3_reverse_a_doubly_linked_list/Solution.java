package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.doubly.p3_reverse_a_doubly_linked_list;

/**
 * https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
 */
public class Solution {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList(new int[]{10,8,4,2});
        System.out.println(list.getListPrinted());
    }

}

class Node {
    int data;
    Node next;
    Node previous;

    public Node(int data) {
        this.data = data;
    }
}

class CustomLinkedList {
    Node head;

    public CustomLinkedList(int[] ints) {
        head = push(ints, 0, null);
    }

    private Node push(int[] ints, int i, Node previous) {
        if (i == ints.length) return null;
        Node newNode = new Node(ints[i]);
        newNode.next = push(ints, i + 1, newNode);
        newNode.previous = previous;
        return newNode;
    }

    public String getListPrinted() {
        String l = "";
        while (head != null) {
            l += head.data + " <-> ";
            head = head.next;
        }
        return l;
    }
}
