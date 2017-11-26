package net.learning.computerscience.hackerrank.datastructures.linkedlists.p6_print_elements_in_reverse;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    void reversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        if (head == null) return;

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

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }

}
