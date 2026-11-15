class Solution {
    public int[] plusOne(int[] digits) {
        // Start at the least significant digit.
        for (int i = digits.length - 1; i >= 0; i--) {
            // Increment without carrying if the digit is below nine.
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // Nine becomes zero, carrying one to the next digit.
            digits[i] = 0;
        }

        // All digits were nine, so one extra digit is needed.
        int[] result = new int[digits.length + 1];

        // Java initializes the remaining digits to zero.
        result[0] = 1;
        return result;
    }
}
