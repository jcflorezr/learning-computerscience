package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p49_max_element_for_each_subarray_of_size_k;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getMaxElements() {
        int[] inputArray = {4,2,12,34,23,35,44,55};
        assertThat(Solution.getMaxElements(inputArray, 3), is(equalTo(Arrays.asList(12,34,34,35,44,55))));
    }

    @Test
    public void getMaxElements2() {
        int[] inputArray = {4,2,12,34,23,35,44,55};
        assertThat(Solution.getMaxElements(inputArray, 5), is(equalTo(Arrays.asList(34,35,44,55))));
    }

    @Test
    public void getMaxElements3() {
        int[] inputArray = {4,2,12,34,4,23,4,35,44,2,12,55};
        assertThat(Solution.getMaxElements(inputArray, 6), is(equalTo(Arrays.asList(34,34,35,44,44,44,55))));
    }

}