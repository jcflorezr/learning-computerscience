package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p1_print_elements;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
 */
public class Solution {

    void print(Node node) {

        if (node != null) {
            System.out.println(node.data);
            print(node.next);
        }

    }

}
