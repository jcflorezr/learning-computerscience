package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_AVL_trees.avl_deletion;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getBalancedTree() {
        int[] inputArray = {4,34,23,2,35,44,12,55};
        int[] nodesToDelete = {23,55};
<<<<<<< HEAD
        assertThat(Solution.getBalancedTree(inputArray, nodesToDelete), is(equalTo(Arrays.asList(23,4,2,12,35,34,44,55))));
=======
        assertThat(Solution.getBalancedTree(inputArray, nodesToDelete), is(equalTo(Arrays.asList(12,4,2,35,34,44))));
>>>>>>> [data-structures][trees][avl] deleting nodes in an avl tree
    }

    @Test
    public void getBalancedTree2() {
        int[] inputArray = {3,2,4,5,6};
        int[] nodesToDelete = {4};
<<<<<<< HEAD
        assertThat(Solution.getBalancedTree(inputArray, nodesToDelete), is(equalTo(Arrays.asList(3,2,5,4,6))));
=======
        assertThat(Solution.getBalancedTree(inputArray, nodesToDelete), is(equalTo(Arrays.asList(3,2,5,6))));
>>>>>>> [data-structures][trees][avl] deleting nodes in an avl tree
    }

    @Test
    public void getBalancedTree3() {
        int[] inputArray = {14,25,21,10,23,7,26,12,30,16,19};
        int[] nodesToDelete = {10,16,-1};
<<<<<<< HEAD
        assertThat(Solution.getBalancedTree(inputArray, nodesToDelete), is(equalTo(Arrays.asList(21,14,10,7,12,16,19,25,23,26,30))));
=======
        assertThat(Solution.getBalancedTree(inputArray, nodesToDelete), is(equalTo(Arrays.asList(21,14,7,12,19,25,23,26,30))));
>>>>>>> [data-structures][trees][avl] deleting nodes in an avl tree
    }
}