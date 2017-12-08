package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p13_find_merge_point_of_two_lists;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
 */
public class Solution {
    int FindMergeNode(Node headA, Node headB) {
        Node intersec = null;
        Node nextA = headA;
        Node nextB = headB;
        while (intersec == null && nextA != null) {
            while (intersec == null && nextB != null) {
                intersec = (nextA == nextB) ? nextA : null;
                nextB = nextB.next;
            }
            nextA = nextA.next;
            nextB = headB;
        }
        return intersec != null ? intersec.data : -20000;
    }
}
