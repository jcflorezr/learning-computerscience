package net.learning.computerscience.algorithms.boyermoore;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

    private String text;
    private String pattern;
    private Map<Character, Integer> badMatchTable;

    public BoyerMoore(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.badMatchTable = new HashMap<>();
    }

    public void precomputeTable() {
        int lengthOfPattern = pattern.length();

        for (int i = 0; i < lengthOfPattern; i++) {
            char actualCharacter = pattern.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
            badMatchTable.put(actualCharacter, maxShift);
        }
    }

    public int search() {
        int lengthOfText = this.text.length();
        int lengthOfPattern = this.pattern.length(); // O(1)
        int numOfSkips;

        for (int i = 0; i <= lengthOfText - lengthOfPattern; i = i + numOfSkips) {
            numOfSkips = 0;
            for (int j = lengthOfPattern - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    if (badMatchTable.get(pattern.charAt(j)) != null) {
                        numOfSkips = badMatchTable.get(pattern.charAt(j));
                        break;
                    } else {
                        numOfSkips = lengthOfPattern;
                        break;
                    }
                }
            }
            if (numOfSkips == 0) return i;
        }
        return lengthOfText;
    }
}
