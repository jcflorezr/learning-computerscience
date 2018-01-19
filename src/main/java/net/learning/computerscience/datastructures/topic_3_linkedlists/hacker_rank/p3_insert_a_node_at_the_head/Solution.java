package net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.p3_insert_a_node_at_the_head;

import net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
 */
public class Solution {

    Node insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        return temp;
    }

}
