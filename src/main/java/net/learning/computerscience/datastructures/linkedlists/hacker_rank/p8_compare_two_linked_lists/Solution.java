package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p8_compare_two_linked_lists;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
 */
public class Solution {

    int compareLists(Node headA, Node headB) {

        if (headA == null && headB == null) return 1;
        else if (headA == null || headB == null) return 0;
        else if (headA.data != headB.data) return 0;
        return compareLists(headA.next, headB.next);

    }

}
