package net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.p4_insert_a_node_at_specific_pos;

import net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
 */
public class Solution {

    Node insertNth(Node head, int data, int position) {
        Node temp = new Node();
        temp.data = data;
        if (head == null) {
            head = temp;
            // this else if was added because the original list
            // is initialised with a default value (¬¬),
            // the author has made me waste a lot of time in this very basic problem
        } else if (position == 0){
            temp.next = head;
            return temp;
        } else {
            Node previous = head;
            for (int i = 1; i < position; i++) {
                previous = previous.next;
            }
            temp.next = previous.next;
            previous.next = temp;
        }
        return head;
    }

}
