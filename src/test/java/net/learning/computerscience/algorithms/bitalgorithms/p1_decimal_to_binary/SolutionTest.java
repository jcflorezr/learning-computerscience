package net.learning.computerscience.algorithms.bitalgorithms.p1_decimal_to_binary;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void decimalToBinary1() {
        assertThat(Solution.decimalToBinary(257), is(equalTo(new int[] {1,0,0,0,0,0,0,0,1})));
    }

    @Test
    public void decimalToBinary2() {
        assertThat(Solution.decimalToBinary(2542), is(equalTo(new int[] {1,0,0,1,1,1,1,0,1,1,1,0})));
    }

    @Test
    public void decimalToBinary3() {
        assertThat(Solution.decimalToBinary(646), is(equalTo(new int[] {1,0,1,0,0,0,0,1,1,0})));
    }

    @Test
    public void decimalToBinary4() {
        assertThat(Solution.decimalToBinary(10487), is(equalTo(new int[] {1,0,1,0,0,0,1,1,1,1,0,1,1,1})));
    }

    @Test
    public void decimalToBinary5() {
        assertThat(Solution.decimalToBinary(0), is(equalTo(new int[] {0})));
    }

    @Test
    public void decimalToBinary6() {
        assertThat(Solution.decimalToBinary(25), is(equalTo(new int[] {1,1,0,0,1})));
    }
}