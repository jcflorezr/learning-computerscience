package net.learning.computerscience.hackerrank.datastructures.linkedlists.p1_print_elements;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

public class Solution {

    void print(Node node) {

        if (node != null) {
            System.out.println(node.data);
            print(node.next);
        }

    }

}
