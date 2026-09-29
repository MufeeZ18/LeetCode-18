import java.util.Arrays; // Provides array sorting.

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort by right endpoint; avoid subtraction because coordinates can overflow.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // At least one balloon exists.
        int arrowPosition = points[0][1]; // Hit the first balloon at its right edge.

        for (int i = 1; i < points.length; i++) { // Check each remaining balloon.
            if (points[i][0] > arrowPosition) { // Current arrow cannot hit it.
                arrows++; // Shoot another arrow.
                arrowPosition = points[i][1]; // Place it at this balloon's right edge.
            }
        }

        return arrows; // Return the minimum number of arrows.
    }
}
