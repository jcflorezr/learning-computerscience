package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p15_reverse_a_doubly_linked_list;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
 */
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
