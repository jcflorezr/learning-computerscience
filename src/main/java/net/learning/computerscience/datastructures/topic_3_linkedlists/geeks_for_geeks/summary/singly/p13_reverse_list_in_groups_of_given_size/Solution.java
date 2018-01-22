package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.singly.p13_reverse_list_in_groups_of_given_size;

/**
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class Solution {

    public static void main(String[] args) {
        LinkedList list = new LinkedList().populateLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(reverseList(list, 4));
    }

    private static LinkedList reverseList(LinkedList list, int numOfElems) {
        list.head = reverseList(list.head, numOfElems);
        return list;
    }

    private static Node reverseList(Node head, int numOfElems) {

        Node current = head;
        Node previous = null;
        Node next = null;
        int numOfElem = 0;

        while (numOfElem < numOfElems && current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            numOfElem++;
        }

        if (next != null) head.next = reverseList(next, numOfElems);

        return previous;
    }

}

class LinkedList {

    Node head;

    public LinkedList populateLinkedList(int[] ints) {
        head = populateLinkedList(new Node(), ints, 0);
        return this;
    }

    private Node populateLinkedList(Node node, int[] ints, int i) {
        if (i == ints.length) return node;
        node = new Node();
        node.data = ints[i];
        node.next = populateLinkedList(node.next, ints, ++i);
        return node;
    }

    public String toString() {
        String list = "";
        while (head != null) {
            list += head.data + " -> ";
            head = head.next;
        }
        return list;
    }

}

class Node {
    int data;
    Node next;
}
