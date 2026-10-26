import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>(); // Values from the previous k indices.

        for (int i = 0; i < nums.length; i++) { // Visit each index once.
            if (i > k) {
                window.remove(nums[i - k - 1]); // Remove the index now too far away.
            }

            if (window.contains(nums[i])) {
                return true; // Same value found within distance k.
            }

            window.add(nums[i]); // Include this value for future checks.
        }

        return false; // No qualifying pair exists.
    }
}
