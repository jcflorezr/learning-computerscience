package net.learning.computerscience.hackerrank.datastructures.linkedlists.p15_reverse_a_doubly_linked_list;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    Node Reverse(Node head) {
        Node current = Reverse1(head);
        while(current.prev != null) {
            current = current.prev;
        }
        return current;
    }

    Node Reverse1(Node current) {
        if (current == null) return null;
        Node newNext = current.prev;
        current.prev = Reverse1(current.next);
        current.next = newNext;
        return current;
    }

}
