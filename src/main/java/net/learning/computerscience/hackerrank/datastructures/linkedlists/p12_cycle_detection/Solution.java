package net.learning.computerscience.hackerrank.datastructures.linkedlists.p12_cycle_detection;

import net.learning.computerscience.hackerrank.datastructures.linkedlists.Node;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    boolean hasCycle(Node head) {
        Set<Node> references = new HashSet<Node>();
        Node current = head;
        while(current != null) {
            if (references.contains(current)) return true;
            references.add(current);
            current = current.next;
        }
        return false;
    }
}
