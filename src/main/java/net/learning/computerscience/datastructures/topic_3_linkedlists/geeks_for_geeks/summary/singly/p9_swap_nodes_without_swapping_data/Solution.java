package net.learning.computerscience.datastructures.topic_3_linkedlists.geeks_for_geeks.summary.singly.p9_swap_nodes_without_swapping_data;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 */
public class Solution {

    public static void main(String[] args) {
        Node list = createLinkedList(new Node(), asList(10, 15, 12, 13, 20, 14), 0);
        findAndSwapNodes(list, 13, 14, null, null, null, null, false, false);
        System.out.println();
    }

    private static Node findAndSwapNodes(Node list, int x, int y, Node previousTempNode1, Node previousTempNode2, Node tempNode1, Node tempNode2, boolean foundX, boolean foundY) {
        if (!foundX) {
            if (list.data == x) {
                tempNode1 = list;
                foundX = true;
            } else {
                previousTempNode1 = list;
            }
            findAndSwapNodes(list.next, x, y, previousTempNode1, previousTempNode2, tempNode1, tempNode2, foundX, foundY);
        } else if (!foundY) {
            if (list.data == y) {
                tempNode2 = list;
                foundY = true;
            } else {
                previousTempNode2 = list;
            }
            findAndSwapNodes(list.next, x, y, previousTempNode1, previousTempNode2, tempNode1, tempNode2, foundX, foundY);
        } else {
            swapNodes(previousTempNode1, tempNode1, previousTempNode2, tempNode2);
        }

        return list;
    }

    private static void swapNodes(Node previousTempNode1, Node tempNode1, Node previousTempNode2, Node tempNode2) {
        if (previousTempNode1 != null) previousTempNode1.next = tempNode2;
        previousTempNode2.next = tempNode1;
        Node aux = tempNode1.next;
        tempNode1.next = tempNode2.next;
        tempNode2.next = aux;
    }

    private static Node createLinkedList(Node linkedList, List<Integer> integers, int i) {
        if (i == integers.size()) return null;
        linkedList.data = integers.get(i);
        linkedList.next = createLinkedList(new Node(), integers, i + 1);
        return linkedList;
    }

}

class Node {

    int data;
    Node next;

}
