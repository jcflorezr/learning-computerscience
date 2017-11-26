package net.learning.computerscience.hackerrank.datastructures.linkedlists.p7_reversing_a_linked_list;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    Node reverse(Node head) {

        if (head == null) return head;

        Node current = head;
        Node next = current.next;
        Node nNext = next.next;
        current.next = null;

        while (next != null) {
            next.next = current;
            current = next;
            next = nNext;
            if (next != null) {
                nNext = next.next;
            }
        }

        return current;

    }

}
