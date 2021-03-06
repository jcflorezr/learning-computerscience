package net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.p14_insert_element_in_sorted_list;

import net.learning.computerscience.datastructures.topic_3_linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 */
public class Solution {

    Node SortedInsert(Node head, int data) {
        if (head == null) {
            Node newNode = new Node();
            newNode.data = data;
            head = newNode;
        } else {
            Node next = head;
            while (next != null && data > next.data && next.next != null) {
                next = next.next;
            }
            Node newNode = new Node();
            newNode.data = data;
            if (data > next.data) {
                newNode.prev = next;
                next.next = newNode;
            } else {
                newNode.prev = next.prev;
                newNode.next = next;
                next.prev.next = newNode;
                next.prev = newNode;
            }
        }
        return head;
    }

}
