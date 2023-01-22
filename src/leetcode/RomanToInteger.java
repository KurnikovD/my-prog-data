package leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = getRomanValue(s.charAt(i));
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    private int getRomanValue(char charAt) {
        return switch (charAt) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        assertEquals(1996, romanToInteger.romanToInt("MCMXCVI"));
    }
}
