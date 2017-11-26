package net.learning.computerscience.hackerrank.datastructures.linkedlists.p5_delete_a_node;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    Node delete(Node head, int position) {

        if (head == null) return head;
        if (position == 0) {
            head = head.next;
        } else {
            Node current = head;
            Node previous = null;
            for (int i = 1; i <= position; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }
        return head;
    }

}
