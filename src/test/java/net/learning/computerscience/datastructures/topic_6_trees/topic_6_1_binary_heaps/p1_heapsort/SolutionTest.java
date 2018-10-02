package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p1_heapsort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void heapSort() {
        assertThat(Solution.heapSort(new int[]{3,5,7,6,2,1,4,8}), is(equalTo(new int[] {1,2,3,4,5,6,7,8})));
    }

}