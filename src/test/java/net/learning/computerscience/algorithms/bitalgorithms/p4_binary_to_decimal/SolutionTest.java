package net.learning.computerscience.algorithms.bitalgorithms.p4_binary_to_decimal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void binaryToDecimal1() {
        assertThat(Solution.binaryToDecimal("1110101"), is(equalTo(117)));
    }

    @Test
    public void binaryToDecimal2() {
        assertThat(Solution.binaryToDecimal("110010001001011"), is(equalTo(25675)));
    }

    @Test
    public void binaryToDecimal3() {
        assertThat(Solution.binaryToDecimal("1000101000"), is(equalTo(552)));
    }

    @Test
    public void binaryToDecimal4() {
        assertThat(Solution.binaryToDecimal("1000100"), is(equalTo(68)));
    }

    @Test
    public void binaryToDecimal5() {
        assertThat(Solution.binaryToDecimal("11001011000100"), is(equalTo(12996)));
    }

    @Test
    public void binaryToDecimal6() {
        assertThat(Solution.binaryToDecimal("01101110101"), is(equalTo(885)));
    }

    @Test
    public void binaryToDecimal7() {
        assertThat(Solution.binaryToDecimal("0"), is(equalTo(0)));
    }

    @Test
    public void binaryToDecimal8() {
        assertThat(Solution.binaryToDecimal("1"), is(equalTo(1)));
    }

    @Test
    public void binaryToDecimal9() {
        assertThat(Solution.binaryToDecimal("000000000000010"), is(equalTo(2)));
    }
}