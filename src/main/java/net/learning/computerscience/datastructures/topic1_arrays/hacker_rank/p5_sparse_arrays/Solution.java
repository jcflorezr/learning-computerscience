package net.learning.computerscience.datastructures.topic1_arrays.hacker_rank.p5_sparse_arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n];
        for(int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        int queries = in.nextInt();
        String[] stringsQueries = new String[queries];
        for(int i = 0; i < queries; i++) {
            stringsQueries[i] = in.next();
        }

        for (int i = 0; i < stringsQueries.length; i++) {
            int matchCount = 0;
            for (int j = 0; j < strings.length; j++) {
                if (stringsQueries[i].equals(strings[j])) matchCount++;
            }
            System.out.println(matchCount);
        }
        in.close();
    }

}
