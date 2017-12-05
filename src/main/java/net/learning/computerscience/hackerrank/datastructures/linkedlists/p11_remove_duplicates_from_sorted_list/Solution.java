package net.learning.computerscience.hackerrank.datastructures.linkedlists.p11_remove_duplicates_from_sorted_list;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {
    Node RemoveDuplicates(Node head) {
        if (head == null) return head;
        RemoveDuplicates(head.next);
        if (head.next != null) {
            if (head.data == head.next.data) {
                head.next = head.next.next;
            }
        }
        return head;
    }
}
