package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p10_get_node_value;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
 */
public class Solution {

    int GetNode(Node head, int n) {
        if (head == null) return 0;
        CustomQueue queue = new CustomQueue();
        populateQueue(queue, head);
        return get(queue.get(), n).data;
    }

    Node get(Node head, int n) {
        if (n == 0) return head;
        return get(head.next, n - 1);
    }

    void populateQueue(CustomQueue queue, Node node) {
        if (node.next != null) populateQueue(queue, node.next);
        queue.insert(node.data);
    }

    class CustomQueue {
        int data;
        Node head;

        void insert(int data) {
            Node newNode = new Node();
            newNode.data = data;
            if (head == null) head = newNode;
            else getTail(head).next = newNode;
        }

        private Node getTail(Node node) {
            if (node.next == null) return node;
            return getTail(node.next);
        }

        Node get() {
            return head;
        }
    }

}
