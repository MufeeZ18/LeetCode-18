class Solution {
    public int rob(int[] nums) {
        // If there is only one house, rob it
        if (nums.length == 1) {
            return nums[0];
        }

        // Case 1: Rob from first house to second-last house
        int option1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: Rob from second house to last house
        int option2 = robLinear(nums, 1, nums.length - 1);

        // Return the better of the two cases
        return Math.max(option1, option2);
    }

    private int robLinear(int[] nums, int start, int end) {
        // prev1 stores max profit till previous house
        int prev1 = 0;

        // prev2 stores max profit till house before previous
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            // If we rob current house, add nums[i] to prev2
            int robCurrent = prev2 + nums[i];

            // If we skip current house, keep prev1
            int skipCurrent = prev1;

            // Current best is max of robbing or skipping
            int current = Math.max(robCurrent, skipCurrent);

            // Shift values forward for next iteration
            prev2 = prev1;
            prev1 = current;
        }

        // Final best for this linear range
        return prev1;
    }
}
