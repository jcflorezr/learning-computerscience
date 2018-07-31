package net.learning.computerscience.algorithms.bitalgorithms.p1_decimal_to_binary;

public class Solution {

    public static int[] decimalToBinary(int decimalNum) {
        int power = 1;
        while (Math.pow(2, power) < decimalNum) {
            power++;
        }
        int[] binaryNum = new int[power];
        for (int i = power - 1; i >= 0; i--) {
            binaryNum[i] = decimalNum % 2;
            decimalNum /= 2;
        }
        return binaryNum;
    }

}
