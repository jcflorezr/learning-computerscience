package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p18_my_own_avl_tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionV2Test {

    private AVLTree currentTree;

    @Before
    public void init() {
        currentTree = new SolutionV2().getTree(new int[]{8,3,6,9,5,2,7,4});
    }

    @Test
    public void traversals() {
        assertEquals(Arrays.asList(2,3,4,5,6,7,8,9), testInOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(8,3,2,6,5,4,7,9), testPreOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(2,4,5,7,6,3,9,8), testPostOrderTraversal(currentTree.root, new ArrayList<>()));
    }

    @Test
    public void deleteLeafNode() {
        currentTree.deleteNode(2);
        assertEquals(Arrays.asList(3,4,5,6,7,8,9), testInOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(8,3,6,5,4,7,9), testPreOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(4,5,7,6,3,9,8), testPostOrderTraversal(currentTree.root, new ArrayList<>()));
        currentTree.deleteNode(4);
        assertEquals(Arrays.asList(3,5,6,7,8,9), testInOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(8,3,6,5,7,9), testPreOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(5,7,6,3,9,8), testPostOrderTraversal(currentTree.root, new ArrayList<>()));
    }

    @Test
    public void deleteNodeWith1Child() {
        currentTree.deleteNode(5);
        assertEquals(Arrays.asList(2,3,4,6,7,8,9), testInOrderTraversal(currentTree.root));
        assertEquals(Arrays.asList(8,3,2,6,4,7,9), testPreOrderTraversal(currentTree.root));
        assertEquals(Arrays.asList(2,4,7,6,3,9,8), testPostOrderTraversal(currentTree.root));
    }

    @Test
    public void deleteNodeWith2Children() {
        currentTree.deleteNode(8);
        assertEquals(Arrays.asList(2,3,4,5,6,7,9), testInOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(7,3,2,6,5,4,9), testPreOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(2,4,5,6,3,9,7), testPostOrderTraversal(currentTree.root, new ArrayList<>()));
        currentTree.deleteNode(3);
        assertEquals(Arrays.asList(2,4,5,6,7,9), testInOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(7,2,6,5,4,9), testPreOrderTraversal(currentTree.root, new ArrayList<>()));
        assertEquals(Arrays.asList(4,5,6,2,9,7), testPostOrderTraversal(currentTree.root, new ArrayList<>()));
    }

    private List<Integer> testInOrderTraversal(AugmentedNode node) {
        return testInOrderTraversal(node, new ArrayList<>());
    }

    private List<Integer> testPreOrderTraversal(AugmentedNode node) {
        return testPreOrderTraversal(node, new ArrayList<>());
    }

    private List<Integer> testPostOrderTraversal(AugmentedNode node) {
        return testPostOrderTraversal(node, new ArrayList<>());
    }

    private List<Integer> testInOrderTraversal(AugmentedNode node, List<Integer> expectedElements) {
        if (node == null) return null;
        testInOrderTraversal(node.leftChild, expectedElements);
        expectedElements.add(node.data);
        testInOrderTraversal(node.rightChild, expectedElements);
        return expectedElements;
    }

    private List<Integer> testPreOrderTraversal(AugmentedNode node, List<Integer> expectedElements) {
        if (node == null) return null;
        expectedElements.add(node.data);
        testPreOrderTraversal(node.leftChild, expectedElements);
        testPreOrderTraversal(node.rightChild, expectedElements);
        return expectedElements;
    }

    private List<Integer> testPostOrderTraversal(AugmentedNode node, List<Integer> expectedElements) {
        if (node == null) return null;
        testPostOrderTraversal(node.leftChild, expectedElements);
        testPostOrderTraversal(node.rightChild, expectedElements);
        expectedElements.add(node.data);
        return expectedElements;
    }

}