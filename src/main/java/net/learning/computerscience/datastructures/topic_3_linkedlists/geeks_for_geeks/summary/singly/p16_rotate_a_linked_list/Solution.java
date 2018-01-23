package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.singly.p16_rotate_a_linked_list;

/**
 * https://www.geeksforgeeks.org/rotate-a-linked-list/
 */
public class Solution {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList(new int[]{10,20,30,40,50,60});
        list.head = rotateList(list.head, list.getLastNode(), 4);
        System.out.println(list.getListPrinted());

        list = new CustomLinkedList(new int[]{3,8,1,9,5,2,5});
        list.head = rotateList(list.head, list.getLastNode(), 16);
        System.out.println(list.getListPrinted());

    }

    private static Node rotateList(Node current, Node previous, int rotate) {
        if (rotate == 0) {
            previous.next = null;
            return current;
        }
        previous.next = current;
        return rotateList(current.next, current, rotate - 1);
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

    private Node push(int[] ints, int i) {
        if (i == ints.length) return null;
        Node newNode = new Node(ints[i]);
        newNode.next = push(ints, i + 1);
        return newNode;
    }

    public Node getLastNode() {
        return head == null ? null : getLastNode(head);
    }

    private Node getLastNode(Node node) {
        return (node.next == null) ? node : getLastNode(node.next);
    }

    public String getListPrinted() {
        String l = "";
        while (head != null) {
            l += head.data + " -> ";
            head = head.next;
        }
        return l;
    }

}
