package net.learning.computerscience.algorithms.bitalgorithms.p2_hexadecimal_to_decimal;

public class Solution {

    public static int hexadecimalToDecimal(String hexNumber) {
        int power = hexNumber.length() - 1;
        int decimalNum = 0;
        for (char digit : hexNumber.toCharArray()) {
            decimalNum += Math.pow(16, power) * getDecimal(digit);
            power--;
        }
        return decimalNum;
    }

    private static int getDecimal(char digit) {
        return (digit >= '0' && digit <= '9') ? digit - 48 : digit - 55;
    }

}
