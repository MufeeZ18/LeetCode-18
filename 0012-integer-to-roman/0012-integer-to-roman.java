class Solution {
    public String intToRoman(int num) {
        // Include standard values and subtractive cases in descending order.
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        // Match each value to its Roman numeral.
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // Build the answer without repeatedly copying strings.
        StringBuilder result = new StringBuilder();

        // Consider each value from largest to smallest.
        for (int i = 0; i < values.length; i++) {
            // Use the current symbol as many times as it fits.
            while (num >= values[i]) {
                // Append its Roman representation.
                result.append(symbols[i]);
                // Remove its value from the remaining number.
                num -= values[i];
            }
        }

        // Return the completed numeral.
        return result.toString();
    }
}
