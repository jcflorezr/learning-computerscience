package net.learning.computerscience.algorithms.bitalgorithms.p6_twos_complement;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void twosComplement1() {
        assertThat(Solution.twosComplement("01101110"), is(equalTo("10010010")));
    }

    @Test
    public void twosComplement2() {
        assertThat(Solution.twosComplement("00010010"), is(equalTo("11101110")));
    }

    @Test
    public void twosComplement3() {
        assertThat(Solution.twosComplement("01001111"), is(equalTo("10110001")));
    }

    @Test
    public void twosComplement4() {
        assertThat(Solution.twosComplement("00000110"), is(equalTo("11111010")));
    }

    @Test
    public void twosComplement5() {
        assertThat(Solution.twosComplement("01111111"), is(equalTo("10000001")));
    }
}