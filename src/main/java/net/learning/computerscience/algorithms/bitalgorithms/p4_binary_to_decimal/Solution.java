package net.learning.computerscience.algorithms.bitalgorithms.p4_binary_to_decimal;

public class Solution {

    public static int binaryToDecimal(String binaryNum) {
        int decimalNum = 0;
        int power = binaryNum.length() - 1;
        for (char digit : binaryNum.toCharArray()) {
            decimalNum += Character.getNumericValue(digit) * Math.pow(2, power);
            power--;
        }
        return decimalNum;
    }

}
