package net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.p9_merge_two_sorted_linked_lists;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;
import net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 */
public class Solution {

    Node mergeLists(Node a, Node b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.data < b.data) {
            a.next = mergeLists(a.next, b);
            return a;
        } else {
            b.next = mergeLists(a, b.next);
            return b;
        }
    }

}
