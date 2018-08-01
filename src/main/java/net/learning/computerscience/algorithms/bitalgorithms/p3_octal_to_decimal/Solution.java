package net.learning.computerscience.algorithms.bitalgorithms.p3_octal_to_decimal;

public class Solution {

    public static int octalToDecimal(String octalNum) {
        int decimalNum = 0;
        int power = octalNum.length() - 1;
        for (char digit : octalNum.toCharArray()) {
            decimalNum += Character.getNumericValue(digit) * Math.pow(8, power);
            power--;
        }
        return decimalNum;
    }

}
