package net.learning.computerscience.hackerrank.datastructures.linkedlists.p3_insert_a_node_at_the_head;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    Node insert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        return temp;
    }

}
