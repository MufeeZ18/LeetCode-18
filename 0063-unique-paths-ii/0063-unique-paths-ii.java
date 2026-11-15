class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Read the grid dimensions.
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        // Store path counts using a single row.
        int[] dp = new int[cols];

        // Seed the starting cell; an obstacle will reset it to zero.
        dp[0] = 1;

        // Process the grid from top to bottom.
        for (int row = 0; row < rows; row++) {
            // Process each row from left to right.
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    // No path can pass through an obstacle.
                    dp[col] = 0;
                } else if (col > 0) {
                    // Combine paths from above and from the left.
                    dp[col] += dp[col - 1];
                }
                // In column zero, keep only paths from above.
            }
        }

        // Return the number of paths reaching the destination.
        return dp[cols - 1];
    }
}
