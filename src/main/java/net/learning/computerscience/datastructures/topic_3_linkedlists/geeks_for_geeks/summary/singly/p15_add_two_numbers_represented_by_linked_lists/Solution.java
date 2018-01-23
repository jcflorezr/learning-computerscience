package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.singly.p15_add_two_numbers_represented_by_linked_lists;

/**
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 */
public class Solution {

    public static void main(String[] args) {
        CustomLinkedList list1 = new CustomLinkedList(new int[]{7,5,9,4,6});
        CustomLinkedList list2 = new CustomLinkedList(new int[]{8,4});
        int num1 = getRepresentativeNumber(list1.head);
        int num2 = getRepresentativeNumber(list2.head);
        CustomLinkedList resultList = new CustomLinkedList(String.valueOf(num1 + num2));
        System.out.println(resultList.getListPrinted());

        list1 = new CustomLinkedList(new int[]{5,6,3});
        list2 = new CustomLinkedList(new int[]{8,4,2});
        num1 = getRepresentativeNumber(list1.head);
        num2 = getRepresentativeNumber(list2.head);
        resultList = new CustomLinkedList(String.valueOf(num1 + num2));
        System.out.println(resultList.getListPrinted());
    }

    private static int getRepresentativeNumber(Node node) {
        if (node.next == null) return node.data;
        return Integer.parseInt("" + getRepresentativeNumber(node.next) + node.data);
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

    public CustomLinkedList(String number) {
        this(number.chars().map(c -> c - '0').toArray(), true);
    }

    private CustomLinkedList(int[] ints, boolean inversely) {
        if (inversely) head = pushInversely(ints, null, 0);
    }

    private Node push(int[] ints, int i) {
        if (i == ints.length) return null;
        Node node = new Node(ints[i]);
        node.next = push(ints, i + 1);
        return node;
    }

    private Node pushInversely(int[] ints, Node node, int i) {
        if (i == ints.length) return node;
        Node newNode = new Node(ints[i]);
        newNode.next = node;
        return pushInversely(ints, newNode, i + 1);
    }

    String getListPrinted() {
        String l = "";
        while (head != null) {
            l += head.data + " -> ";
            head = head.next;
        }
        return l;
    }
}
