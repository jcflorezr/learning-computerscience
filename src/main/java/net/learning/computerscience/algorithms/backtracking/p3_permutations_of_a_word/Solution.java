package net.learning.computerscience.algorithms.backtracking.p3_permutations_of_a_word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static List<List<Character>> getPermutations(Character[] word) {
        List<List<Character>> permutations = new ArrayList<>();
        getPermutations(word, word.length, 0, permutations);
        return permutations;
    }

    private static void getPermutations(Character[] word, int level, int idx, List<List<Character>> permutations) {
        if (idx == word.length) {
            permutations.add(retrieveElements(word));
            return;
        }
        int n = level == word.length ? 0 : level;
        for (; n >= 0; n--) {
            getPermutations(word, level - 1, idx + 1, permutations);
            if (idx > 0) {
                rotateLetters(word, level + 1, idx - 1);
            }
        }
    }

    private static void rotateLetters(Character[] word, int subWordLength, int initialIdx) {
        for (int i = initialIdx; i < word.length - 1; i++) {
            int newIdx = ((i + subWordLength - 1) % subWordLength);
            newIdx = (newIdx + subWordLength >= word.length) ? newIdx : newIdx + subWordLength;
            Character temp = word[newIdx];
            word[newIdx] = word[i];
            word[i] = temp;
        }
    }

    private static List<Character> retrieveElements(Character[] elements) {
        return Arrays.stream(elements).collect(Collectors.toList());
    }

}
