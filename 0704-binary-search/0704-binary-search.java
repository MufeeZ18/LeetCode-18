class Solution {
    public int search(int[] nums, int target) {
        // Start pointer at the beginning of the array
        int left = 0;
        
        // End pointer at the last index of the array
        int right = nums.length - 1;

        // Continue searching while the range is valid
        while (left <= right) {
            // Find the middle index safely
            int mid = left + (right - left) / 2;

            // If middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }
            
            // If target is greater, ignore left half
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target was not found in the array
        return -1;
    }
}
