package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.doubly.p3_reverse_a_doubly_linked_list;

/**
 * https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
 */
public class Solution {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList(new int[]{10,8,4,2});
        System.out.println(list.getListPrinted());
        list.head = reverseList(list.head, null);
        System.out.println(list.getListPrinted());
    }

    private static Node reverseList(Node current, Node previous) {
        if (current == null) return previous;
        Node temp = current.next;
        current.next = current.previous;
        current.previous = temp;
        return reverseList(temp, current);
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
        Node temp = head;
        while (temp != null) {
            l += temp.data + " <-> ";
            temp = temp.next;
        }
        return l;
    }
}
