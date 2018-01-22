package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.singly.p14_detect_and_remove_loop;

/**
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */
public class Solution {

    public static void main(String[] args) {
        CustomLinkedList list1 = new CustomLinkedList(new int[]{1, 2, 3, 4, 5});
        CustomLinkedList list2 = new CustomLinkedList(new int[]{6, 7, 8, 9});

        Node lastNodeOfList1 = list1.getLastNode();
        lastNodeOfList1.next = list2.head;
        Node lastNodeOfList2 = list2.getLastNode();
        lastNodeOfList2.next = lastNodeOfList1;

        Node nodeWhereLoopWasDetected = detectLoop(list1);
        list1.head = removeLoop(list1.head, nodeWhereLoopWasDetected);
        System.out.println(list1.printList());
    }

    private static Node detectLoop(CustomLinkedList list1) {
        return detectLoop(list1.head, list1.head, null);
    }

    private static Node detectLoop(Node p, Node q, Node previous) {
        if (p == null || q == null) return null;
        if (p == q && previous != null) return q;
        q = q.next != null ? q.next.next : q.next;
        return detectLoop(p.next, q, p);
    }

    private static Node removeLoop(Node p, Node q) {
        Node nodeToBeFixed = getNodeToBeFixed(p, q, null);
        nodeToBeFixed.next = null;
        return p;
    }

    private static Node getNodeToBeFixed(Node p, Node q, Node previous) {
        if (p == q) return previous;
        return getNodeToBeFixed(p.next, q.next, q);
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class CustomLinkedList {
    Node head;

    public CustomLinkedList(int[] ints) {
        head = push(ints, 0);
    }

    Node push(int[] ints, int i) {
        if (i == ints.length) return null;
        Node node = new Node(ints[i]);
        node.next = push(ints, i + 1);
        return node;
    }

    void push(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
    }

    Node getLastNode() {
        return (head == null) ? head : getLastNode(head);
    }

    private Node getLastNode(Node current) {
        return (current.next == null) ? current : getLastNode(current.next);
    }

    String printList() {
        String l = "";
        while(head != null) {
            l += head.data + " -> ";
            head = head.next;
        }
        return l;
    }
}
