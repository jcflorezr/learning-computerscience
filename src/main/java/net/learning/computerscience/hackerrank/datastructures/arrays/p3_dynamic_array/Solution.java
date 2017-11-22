package net.learning.computerscience.hackerrank.datastructures.arrays.p3_dynamic_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numSequences = in.nextInt();
        int numQueries = in.nextInt();

        ArrayList<ArrayList<Integer>> sequences = new ArrayList<>(numSequences);

        for(int i=0; i < numSequences; i++) {
            sequences.add(new ArrayList<>());
        }

        int lastAnswer = 0;
        int[][] queries = new int[numQueries][3];

        for(int i=0; i < numQueries; i++) {
            for(int j=0; j < 3; j++) {
                queries[i][j] = in.nextInt();
            }
        }

        for(int i=0; i < numQueries; i++) {
            int numSequence = (queries[i][1] ^ lastAnswer) % numSequences;
            ArrayList<Integer> sequence = sequences.get(numSequence);
            if (queries[i][0] == 1) {
                sequence.add(queries[i][2]);
            } else if (queries[i][0] == 2) {
                int index = queries[i][2] % sequence.size();
                lastAnswer = sequence.get(index);
                System.out.println(lastAnswer);
            }
        }

    }

}
