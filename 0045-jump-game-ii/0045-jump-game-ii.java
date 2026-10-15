class Solution {
    public int jump(int[] nums) {
        int jumps = 0;       // Number of jumps taken
        int rangeEnd = 0;    // End of the range reachable with current jumps
        int farthest = 0;    // Farthest index reachable with one more jump

        for (int i = 0; i < nums.length - 1; i++) {
            // Check how far we could jump from this index.
            farthest = Math.max(farthest, i + nums[i]);

            // We've scanned every option for the current jump.
            if (i == rangeEnd) {
                jumps++;             // Commit to the next jump
                rangeEnd = farthest; // Set the new reachable range
            }
        }

        return jumps; // Minimum jumps needed to reach the last index
    }
}
