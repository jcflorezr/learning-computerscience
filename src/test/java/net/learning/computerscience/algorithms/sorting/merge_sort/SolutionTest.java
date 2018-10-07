package net.learning.computerscience.algorithms.sorting.merge_sort;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void mergeSort() {
        int[] elements = {32,-12,0,3,1,12,20,2};
        assertThat(Solution.mergeSort(elements), is(equalTo(new int[]{-12,0,1,2,3,12,20,32})));
    }
}