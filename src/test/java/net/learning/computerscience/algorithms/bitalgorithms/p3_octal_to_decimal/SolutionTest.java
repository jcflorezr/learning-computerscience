package net.learning.computerscience.algorithms.bitalgorithms.p3_octal_to_decimal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void octalToDecimal1() {
        assertThat(Solution.octalToDecimal("014"), is(equalTo(12)));
    }

    @Test
    public void octalToDecimal2() {
        assertThat(Solution.octalToDecimal("2567"), is(equalTo(1399)));
    }

    @Test
    public void octalToDecimal3() {
        assertThat(Solution.octalToDecimal("1224"), is(equalTo(660)));
    }

    @Test
    public void octalToDecimal4() {
        assertThat(Solution.octalToDecimal("723"), is(equalTo(467)));
    }

    @Test
    public void octalToDecimal5() {
        assertThat(Solution.octalToDecimal("7"), is(equalTo(7)));
    }

    @Test
    public void octalToDecimal6() {
        assertThat(Solution.octalToDecimal("0"), is(equalTo(0)));
    }

    @Test
    public void octalToDecimal7() {
        assertThat(Solution.octalToDecimal("88"), is(equalTo(72)));
    }
}