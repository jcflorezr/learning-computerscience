package net.learning.computerscience.datastructures.arrays.hacker_rank.p2_2d_array_ds;

import java.util.Scanner;

public class Solution {

    /* 1. Tried to implement backtracking ommiting the center value (2nd row - 2nd col),
          it did not work because one only number can make the difference in the sum
       2. Tried to implement recursion but it is still to hard for me right now
       3. Finally implemented a quadratic solution with constant space
    */


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int maxSum = -Integer.MAX_VALUE;

        for (int row = 0; row <= 3; row++) {
            for (int col = 0; col <= 3; col++) {
                int currSumRow1 = arr[row][col] + arr[row][col+1] + arr[row][col+2];
                int currSumRow2 = arr[row+1][col+1];
                int currSumRow3 = arr[row+2][col] + arr[row+2][col+1] + arr[row+2][col+2];
                int currSum = currSumRow1 + currSumRow2 + currSumRow3;

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        System.out.println(maxSum);

    }

}
