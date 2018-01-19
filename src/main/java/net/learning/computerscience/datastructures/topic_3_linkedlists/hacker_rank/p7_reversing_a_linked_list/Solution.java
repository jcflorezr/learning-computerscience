package net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.p7_reversing_a_linked_list;

import net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/reverse-a-linked-list
 */
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
