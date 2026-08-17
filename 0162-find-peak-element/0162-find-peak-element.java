class Solution {
    public int findPeakElement(int[] nums) {
        // Start with the full search range
        int left = 0;
        int right = nums.length - 1;

        // Keep searching until both pointers meet
        while (left < right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // If current element is smaller than next,
            // peak must be on the right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, peak is at mid or on the left side
                right = mid;
            }
        }

        // left == right, pointing to a peak element
        return left;
    }
}
