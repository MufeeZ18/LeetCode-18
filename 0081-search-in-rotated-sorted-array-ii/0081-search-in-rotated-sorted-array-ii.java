class Solution {
    public boolean search(int[] nums, int target) {
        // Pointer to the start of the array
        int left = 0;

        // Pointer to the end of the array
        int right = nums.length - 1;

        // Continue while search space is valid
        while (left <= right) {
            // Find middle index safely
            int mid = left + (right - left) / 2;

            // If target is found at mid, return true
            if (nums[mid] == target) {
                return true;
            }

            // If duplicates exist at left, mid, and right,
            // we cannot identify the sorted half confidently
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                // Check if target lies inside the left sorted half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // Check if target lies inside the right sorted half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return false;
    }
}