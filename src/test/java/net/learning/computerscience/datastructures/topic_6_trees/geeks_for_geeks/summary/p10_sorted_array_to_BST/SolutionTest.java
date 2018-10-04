package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p10_sorted_array_to_BST;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void bstFromSortedArray() {
        int[] elements = {2,7,12,24,28,31,37,39,40,45};
        Node tree = Solution.bstFromSortedArray(elements);
        assertEquals(Arrays.asList(28,7,39,2,12,31,40,24,37,45), levelOrderTraversal(tree));
    }

    @Test
    public void bstFromSortedArray2() {
        int[] elements = {-10,-3,0,5,9,13,17,18,21,26,29};
        Node tree = Solution.bstFromSortedArray(elements);
        assertEquals(Arrays.asList(13,0,21,-10,5,17,26,-3,9,18,29), levelOrderTraversal(tree));
    }

    private List<Integer> levelOrderTraversal(Node current) {
        Queue<Node> levelOrderElements = new ArrayDeque<>();
        levelOrderElements.add(current);
        List<Integer> elements = new ArrayList<>();
        while (!levelOrderElements.isEmpty()) {
            Node temp = levelOrderElements.poll();
            if (temp.left != null) levelOrderElements.add(temp.left);
            if (temp.right != null) levelOrderElements.add(temp.right);
            elements.add(temp.data);
        }
        return elements;
    }
}