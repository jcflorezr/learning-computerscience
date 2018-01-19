package net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.p2_insert_node_at_the_tail;

import net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 */
public class Solution {

    Node insert(Node node, int data) {

        if (node == null) {
            node = new Node();
            node.data = data;
        } else {
            insert(node.next, data);
        }
        return node;
    }

}
