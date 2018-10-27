package net.learning.computerscience.algorithms.mathematical.p1_check_if_a_number_is_multiple_of_3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void checkIfMultpleOf3_1() {
        assertFalse(Solution.checkIfMultpleOf3(23));
    }

    @Test
    public void checkIfMultpleOf3_2() {
        assertTrue(Solution.checkIfMultpleOf3(23));
    }
}