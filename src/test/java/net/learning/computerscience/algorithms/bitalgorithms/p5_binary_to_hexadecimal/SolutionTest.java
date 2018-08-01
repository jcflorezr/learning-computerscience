package net.learning.computerscience.algorithms.bitalgorithms.p5_binary_to_hexadecimal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void binaryToHexadecimal1() {
        assertThat(Solution.binaryToHexadecimal("1110101"), is(equalTo("75")));
    }

    @Test
    public void binaryToHexadecimal2() {
        assertThat(Solution.binaryToHexadecimal("110010001001011"), is(equalTo("644B")));
    }

    @Test
    public void binaryToHexadecimal3() {
        assertThat(Solution.binaryToHexadecimal("1000101000"), is(equalTo("228")));
    }

    @Test
    public void binaryToHexadecimal4() {
        assertThat(Solution.binaryToHexadecimal("1000100"), is(equalTo("44")));
    }

    @Test
    public void binaryToHexadecimal5() {
        assertThat(Solution.binaryToHexadecimal("11001011000100"), is(equalTo("32C4")));
    }

    @Test
    public void binaryToHexadecimal6() {
        assertThat(Solution.binaryToHexadecimal("000000000000010"), is(equalTo("0002")));
    }

    @Test
    public void binaryToHexadecimal7() {
        assertThat(Solution.binaryToHexadecimal("01101110101"), is(equalTo("375")));
    }

    @Test
    public void binaryToHexadecimal8() {
        assertThat(Solution.binaryToHexadecimal("1110101"), is(equalTo("75")));
    }
}