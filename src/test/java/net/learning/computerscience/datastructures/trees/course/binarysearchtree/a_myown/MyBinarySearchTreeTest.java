package net.learning.computerscience.datastructures.trees.course.binarysearchtree.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MyBinarySearchTreeTest {

    private MyBinarySearchTree<Integer> myBinarySearchTree;

    @Before
    public void setUp() {
        myBinarySearchTree = new MyBinarySearchTree<>();
    }

    @Test
    public void testBinarySearchTreeOperations() throws Exception {
        List<Integer> list = asList(32,39,6,36,43,8,3,1,7,45);
        list.forEach(element -> myBinarySearchTree.insert(element));

        // in-order traversal
        String expectedResult = "[1, 3, 6, 7, 8, 32, 36, 39, 43, 45]";
        assertThat(myBinarySearchTree.inOrderTraversal().toString(), equalTo(expectedResult));

        // pre-order traversal
        expectedResult = "[32, 6, 3, 1, 8, 7, 39, 36, 43, 45]";
        assertThat(myBinarySearchTree.preOrderTraversal().toString(), equalTo(expectedResult));

        // post-order traversal
        expectedResult = "[1, 3, 7, 8, 6, 36, 45, 43, 39, 32]";
        assertThat(myBinarySearchTree.postOrderTraversal().toString(), equalTo(expectedResult));

        // get maximum element
        assertThat(myBinarySearchTree.getMax(), equalTo(45));

        // get minimum element
        assertThat(myBinarySearchTree.getMin(), equalTo(1));

        // remove the root node
        myBinarySearchTree.remove(32);
        expectedResult = "[8, 6, 3, 1, 7, 39, 36, 43, 45]";
        assertThat(myBinarySearchTree.preOrderTraversal().toString(), equalTo(expectedResult));
    }

}