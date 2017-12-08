package net.learning.computerscience.datastructures.linkedlists.hacker_rank.p12_cycle_detection;

import net.learning.computerscience.datastructures.linkedlists.hacker_rank.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 */
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
