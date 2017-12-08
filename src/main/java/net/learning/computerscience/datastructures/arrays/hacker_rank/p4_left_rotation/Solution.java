package net.learning.computerscience.datastructures.arrays.hacker_rank.p4_left_rotation;

import java.util.Scanner;

public class Solution {

    static int[] leftRotation(int[] a, int d) {
        int[] rotatedArr = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int finalPos = i - d;
            // I thought that d might be greater than the arrays length
            // that is why I created the following while loop
            while (finalPos < 0) {
                finalPos = (i - d) + a.length;
            }
            rotatedArr[finalPos] = a[i];
        }
        return rotatedArr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        in.close();
    }

}
