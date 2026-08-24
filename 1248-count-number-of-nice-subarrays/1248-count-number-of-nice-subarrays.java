class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Count subarrays with exactly k odd numbers
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        // If k is negative, no valid subarray is possible
        if (k < 0) return 0;

        // Left pointer of sliding window
        int left = 0;

        // Number of odd numbers in current window
        int oddCount = 0;

        // Total valid subarrays with at most k odd numbers
        int result = 0;

        // Expand the window using right pointer
        for (int right = 0; right < nums.length; right++) {
            // If current number is odd, increase odd count
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            // Shrink the window until it has at most k odd numbers
            while (oddCount > k) {
                // If left number is odd, reduce odd count
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }

                // Move left pointer forward
                left++;
            }

            // All subarrays ending at right and starting from left to right are valid
            result += right - left + 1;
        }

        // Return total count of valid subarrays
        return result;
    }
}
