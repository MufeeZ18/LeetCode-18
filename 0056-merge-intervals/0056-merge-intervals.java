import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Add the first interval as the starting point
        result.add(intervals[0]);

        // Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // Get the last merged interval from result
            int[] last = result.get(result.size() - 1);

            // If current interval overlaps with last merged interval
            if (intervals[i][0] <= last[1]) {
                // Extend the end of the last merged interval
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                // No overlap, add current interval as new
                result.add(intervals[i]);
            }
        }

        // Convert list to 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
