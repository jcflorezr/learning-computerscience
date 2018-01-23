package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.circular.p4_split_linked_list_into_two_halves;

/**
 * https://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/
 */
public class Solution {

    public static void main(String[] args) {
        CustomLinkedList list1 = new CustomLinkedList(new int[]{1,2,3,4,5,6});
        CustomLinkedList list2 = new CustomLinkedList(getHeadOfSecondList(list1.head, list1.head, list1.head));
        splitByHalves(list1.head, list1.head, list2.head, list2.head);
        System.out.println(list1.getListPrinted());
        System.out.println(list2.getListPrinted());

        list1 = new CustomLinkedList(new int[]{12,56,2,11,33});
        list2 = new CustomLinkedList(getHeadOfSecondList(list1.head, list1.head, list1.head));
        splitByHalves(list1.head, list1.head, list2.head, list2.head);
        System.out.println(list1.getListPrinted());
        System.out.println(list2.getListPrinted());
    }

    private static Node getHeadOfSecondList(Node head, Node tortoise, Node hare) {
        if (hare.next == head || hare.next.next == head) return tortoise.next;
        return getHeadOfSecondList(head, tortoise.next, hare.next.next);
    }

    private static void splitByHalves(Node head1, Node current1, Node head2, Node current2) {
        while (current1.next != head2) {
            current1 = current1.next;
        }
        current1.next = head1;

        while (current2.next != head1) {
            current2 = current2.next;
        }
        current2.next = head2;
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

    public CustomLinkedList(Node head) {
        this.head = head;
    }

    public String getListPrinted() {
        if (head == null) return null;
        String l = head.data + " -> ";
        Node temp = head.next;
        while (temp != head) {
            l += temp.data + " -> ";
            temp = temp.next;
        }
        return l;
    }

    private Node push(int[] ints, int i) {
        if (i == ints.length) return head;
        Node newNode = new Node(ints[i]);
        if (head == null) head = newNode;
        newNode.next = push(ints, i + 1);
        return newNode;
    }
}
