package net.learning.computerscience.algorithms.backtracking.p3_permutations_of_a_word;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getPermutations1() {
        Character[] word = {'A','B','C'};
        List<List<Character>> permutations = Solution.getPermutations(word);
        Set<String> existingPermutations = new HashSet<>();
        assertEquals(6, permutations.size());
        permutations.forEach(permutation -> {
            assertFalse(existingPermutations.contains(permutation));
            existingPermutations.add(Arrays.toString(permutation.toArray()));
        });
    }

    @Test
    public void getPermutations2() {
        Character[] word = {'R','O','A','D'};
        List<List<Character>> permutations = Solution.getPermutations(word);
        Set<String> existingPermutations = new HashSet<>();
        assertEquals(24, permutations.size());
        permutations.forEach(permutation -> {
            assertFalse(existingPermutations.contains(permutation));
            existingPermutations.add(Arrays.toString(permutation.toArray()));
        });
    }

    @Test
    public void getPermutations3() {
        Character[] word = {'R','O','A','D','P'};
        List<List<Character>> permutations = Solution.getPermutations(word);
        Set<String> existingPermutations = new HashSet<>();
        assertEquals(120, permutations.size());
        permutations.forEach(permutation -> {
            assertFalse(existingPermutations.contains(permutation));
            existingPermutations.add(Arrays.toString(permutation.toArray()));
        });
    }

    @Test
    public void getPermutations4() {
        Character[] word = {'R','O','A','D','P','I'};
        List<List<Character>> permutations = Solution.getPermutations(word);
        Set<String> existingPermutations = new HashSet<>();
        assertEquals(720, permutations.size());
        permutations.forEach(permutation -> {
            assertFalse(existingPermutations.contains(permutation));
            existingPermutations.add(Arrays.toString(permutation.toArray()));
        });
    }
}