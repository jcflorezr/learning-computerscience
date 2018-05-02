package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p18_my_own_avl_tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SolutionV1Test {

    private Tree actualTree;

    @Before
    public void init() {
        actualTree = new SolutionV1().getTree(new int[]{8,3,6,9,5,2,7,4});
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
        testInOrderTraversal(actualTree.root, expectedElements);
    }

    @Test
    public void preOrderTraversal() {
        Stack<Integer> expectedElements = new Stack<>();
        expectedElements.push(9);
        expectedElements.push(7);
        expectedElements.push(4);
        expectedElements.push(5);
        expectedElements.push(6);
        expectedElements.push(2);
        expectedElements.push(3);
        expectedElements.push(8);
        testPreOrderTraversal(actualTree.root, expectedElements);
    }

    @Test
    public void postOrderTraversal() {
        Stack<Integer> expectedElements = new Stack<>();
        expectedElements.push(8);
        expectedElements.push(9);
        expectedElements.push(3);
        expectedElements.push(6);
        expectedElements.push(7);
        expectedElements.push(5);
        expectedElements.push(4);
        expectedElements.push(2);
        testPostOrderTraversal(actualTree.root, expectedElements);
    }

    @Test
    public void height() {
        assertEquals(5, actualTree.getHeight());
    }

    private void testInOrderTraversal(Node node, Stack<Integer> elements) {
        if (node == null) return;
        testInOrderTraversal(node.leftChild, elements);
        assertEquals((int) elements.pop(), node.data);
        testInOrderTraversal(node.rightChild, elements);
    }

    private void testPreOrderTraversal(Node node, Stack<Integer> elements) {
        if (node == null) return;
        assertEquals((int) elements.pop(), node.data);
        testPreOrderTraversal(node.leftChild, elements);
        testPreOrderTraversal(node.rightChild, elements);
    }

    private void testPostOrderTraversal(Node node, Stack<Integer> elements) {
        if (node == null) return;
        testPostOrderTraversal(node.leftChild, elements);
        testPostOrderTraversal(node.rightChild, elements);
        assertEquals((int) elements.pop(), node.data);
    }

}