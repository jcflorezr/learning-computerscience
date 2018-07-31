package net.learning.computerscience.algorithms.bitalgorithms.p2_hexadecimal_to_decimal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void hexadecimalToDecimal1() {
        assertThat(Solution.hexadecimalToDecimal("E31"), is(equalTo(3633)));
    }

    @Test
    public void hexadecimalToDecimal2() {
        assertThat(Solution.hexadecimalToDecimal("1AA"), is(equalTo(426)));
    }

    @Test
    public void hexadecimalToDecimal3() {
        assertThat(Solution.hexadecimalToDecimal("FACEB"), is(equalTo(1027307)));
    }

    @Test
    public void hexadecimalToDecimal4() {
        assertThat(Solution.hexadecimalToDecimal("C"), is(equalTo(12)));
    }

    @Test
    public void hexadecimalToDecimal5() {
        assertThat(Solution.hexadecimalToDecimal("F2EBCD"), is(equalTo(15920077)));
    }

    @Test
    public void hexadecimalToDecimal6() {
        assertThat(Solution.hexadecimalToDecimal("1"), is(equalTo(1)));
    }

}