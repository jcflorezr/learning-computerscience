package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p18_my_own_avl_tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SolutionV2Test {

    private AVLTree currentTree;

    @Before
    public void init() {
        currentTree = new SolutionV2().getTree(new int[]{8,3,6,9,5,2,7,4});
    }

    @Test
    public void inOrderTraversal() {
        Stack<Integer> expectedElements = new Stack<>();
        expectedElements.push(9);
        expectedElements.push(8);
        expectedElements.push(7);
        expectedElements.push(6);
        expectedElements.push(5);
        expectedElements.push(4);
        expectedElements.push(3);
        expectedElements.push(2);
        testInOrderTraversal(currentTree.root, expectedElements);
    }

    private void testInOrderTraversal(AugmentedNode node, Stack<Integer> elements) {
        if (node == null) return;
        testInOrderTraversal(node.leftChild, elements);
        assertEquals((int) elements.pop(), node.data);
        System.out.println("|" + node.data + "| " + node.leftChildHeight + " - " + node.rightChildHeight + " - " + node.getHeight());
        testInOrderTraversal(node.rightChild, elements);
    }

}