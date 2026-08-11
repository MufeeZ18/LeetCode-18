class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Start pointer at the beginning of the array
        int left = 0;

        // End pointer at the last index of the array
        int right = nums.length - 1;

        // Binary search until both pointers meet
        while (left < right) {
            // Find the middle index safely
            int mid = left + (right - left) / 2;

            // Make mid even so it can represent the first index of a pair
            if (mid % 2 == 1) {
                mid--;
            }

            // If this pair is valid, single element must be on the right side
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } 
            // Otherwise, the single element is at mid or on the left side
            else {
                right = mid;
            }
        }

        // Left and right meet at the single element
        return nums[left];
    }
}
