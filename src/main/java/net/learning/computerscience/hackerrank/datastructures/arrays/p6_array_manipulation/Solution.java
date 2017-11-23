package net.learning.computerscience.hackerrank.datastructures.arrays.p6_array_manipulation;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] arr = new long[n + 1];
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextInt();
            arr[a] += k;
            if ((b+1) <= n) arr[b+1] -= k;
        }
        long temp = 0;
        long max = 0;
        for (int i = 1; i <= n; i++) {
            temp += arr[i];
            if (max < temp) max = temp;
        }

        System.out.println(max);

        in.close();
    }

}
