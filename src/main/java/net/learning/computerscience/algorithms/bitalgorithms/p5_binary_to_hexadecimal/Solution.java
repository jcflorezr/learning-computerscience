package net.learning.computerscience.algorithms.bitalgorithms.p5_binary_to_hexadecimal;

public class Solution {

    public static String binaryToHexadecimal(String binaryNum) {
        int power = 0;
        int sum = 0;
        String hexNumber = "";
        for (int i = binaryNum.length() - 1; i >= 0; i--) {
            sum += Character.getNumericValue(binaryNum.charAt(i)) * Math.pow(2, power);
            power++;
            if (power == 4 || i == 0) {
                hexNumber = getHexNumber(sum) + hexNumber;
                power = 0;
                sum = 0;
            }
        }
        return hexNumber;
    }

    private static char getHexNumber(int sum) {
        return (char) ((sum < 10) ? sum + 48 : sum + 55);
    }

}
