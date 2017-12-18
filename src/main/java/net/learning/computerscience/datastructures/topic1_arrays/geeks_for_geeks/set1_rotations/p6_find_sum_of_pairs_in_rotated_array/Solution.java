package net.learning.computerscience.datastructures.topic1_arrays.geeks_for_geeks.set1_rotations.p6_find_sum_of_pairs_in_rotated_array;

/**
 * http://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 */
public class Solution {

    public static void main (String[] args) {
//        int arr[] = {11, 15, 6, 8, 9, 10};
//        int result = 16;
        int arr[] = {11, 15, 16, 20, 26, 38, 6, 9, 10};
        int result = 26;

        Node pairs = getPairs(arr, 0, 1, result);
        while (pairs != null) {
            System.out.println("(" + pairs.first + ", " + pairs.second + ")");
            pairs = pairs.next;
        }

        System.out.println("==== Iterative Way ====");

        pairs = getPairsIterativeWay(arr, result);
        while (pairs != null) {
            System.out.println("(" + pairs.first + ", " + pairs.second + ")");
            pairs = pairs.next;
        }
    }

    private static Node getPairs(int[] arr, int idx, int nextIdx, int result) {
        if (idx == arr.length - 1) return null;
        if (nextIdx < arr.length) {
            int first = arr[idx];
            int second = arr[nextIdx];
            int sum = first + second;
            Node previousPair = getPairs(arr, idx, nextIdx + 1, result);
            Node newPair = null;
            if (sum == result) {
                newPair = new Node();
                newPair.first = first;
                newPair.second = second;
            }
            if (newPair != null) {
                newPair.next = previousPair;
                return newPair;
            } else {
                return previousPair;
            }
        }
        return getPairs(arr, idx + 1, idx + 2, result);
    }

    private static Node getPairsIterativeWay(int arr[], int result) {
        Node pairs = null;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int first = arr[i];
                int second = arr[j];
                int sum = first + second;
                if (sum == result) {
                    if (pairs == null) {
                        pairs = new Node(first, second);
                    } else {
                        pairs.insert(first, second);
                    }
                }
            }
        }
        return pairs;
    }

}

class Node {
    int first;
    int second;
    Node next;
    Node head;

    public Node() {
    }

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
        this.head = this;
    }

    void insert(int first, int second) {
        Node newNode = new Node();
        newNode.first = first;
        newNode.second = second;
        Node last = getLast(head);
        last.next = newNode;
    }

    private Node getLast(Node current) {
        if (current.next == null) return current;
        return getLast(current.next);
    }
}
