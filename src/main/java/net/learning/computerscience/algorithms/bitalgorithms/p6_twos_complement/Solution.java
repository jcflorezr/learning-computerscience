package net.learning.computerscience.algorithms.bitalgorithms.p6_twos_complement;

public class Solution {

    public static String twosComplement(String base2Number) {
        String norNumber = "";
        for (char bit : base2Number.toCharArray()) {
            char negativeBit = (char) ((bit == 48) ? 49 : 48);
            norNumber += negativeBit;
        }
        return add1(norNumber);
    }

    private static String add1(String base2Number) {
        int carry = 0;
        int add = 1;
        String complement = "";
        for (int i = base2Number.length() - 1; i >= 0; i--) {
            int bit = Character.getNumericValue(base2Number.charAt(i));
            boolean isCarry = false;
            if (add == 1) {
                isCarry = (bit + add == 2);
                bit = (isCarry ? 0 : bit + add);
                add = 0;
            } else if (carry == 1) {
                isCarry = (bit + carry == 2);
                bit = (isCarry ? 0 : bit + carry);
            }
            carry = (isCarry ? 1 : 0);
            complement = ((char)(bit + '0')) + complement;
        }
        return complement;
    }

}
