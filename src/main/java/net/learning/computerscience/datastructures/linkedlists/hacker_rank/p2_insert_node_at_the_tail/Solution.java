package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p2_insert_node_at_the_tail;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

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
