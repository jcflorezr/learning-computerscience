package net.learning.computerscience.hackerrank.datastructures.linkedlists.p8_compare_two_linked_lists;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    int compareLists(Node headA, Node headB) {

        if (headA == null && headB == null) return 1;
        else if (headA == null || headB == null) return 0;
        else if (headA.data != headB.data) return 0;
        return compareLists(headA.next, headB.next);

    }

}
