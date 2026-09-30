class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length; // Include n in the XOR.

        for (int i = 0; i < nums.length; i++) {
            missing ^= i;       // XOR the expected number at this index.
            missing ^= nums[i]; // Cancel out numbers present in the array.
        }

        return missing; // Only the missing number remains.
    }
}
