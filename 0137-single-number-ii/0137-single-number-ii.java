class Solution {
    public int singleNumber(int[] nums) {
        // Reconstruct the unique number one bit at a time.
        int result = 0;

        // Java int values contain 32 bits, including the sign bit.
        for (int bit = 0; bit < 32; bit++) {
            // Count set bits at the current position.
            int count = 0;

            // Examine this bit in every number.
            for (int num : nums) {
                // Unsigned shift moves the target bit to position zero.
                count += (num >>> bit) & 1;
            }

            // Triplicate contributions disappear modulo three.
            if (count % 3 == 1) {
                // Set the unique number's bit at this position.
                result |= (1 << bit);
            }
        }

        // The reconstructed bits represent the unique signed integer.
        return result;
    }
}
