class Solution {
    // Memo table: memo[i][m] stores the best answer starting from index i with M = m
    private Integer[][] memo;

    // suffix[i] = sum of piles from i to end
    private int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // Initialize memo table
        memo = new Integer[n][n + 1];

        // Build suffix sum array
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        // Start from index 0 with M = 1
        return dfs(0, 1, piles);
    }

    private int dfs(int i, int m, int[] piles) {
        int n = piles.length;

        // If no piles are left, current player gets 0
        if (i >= n) {
            return 0;
        }

        // If current player can take all remaining piles, do that
        if (i + 2 * m >= n) {
            return suffix[i];
        }

        // Return cached result if already computed
        if (memo[i][m] != null) {
            return memo[i][m];
        }

        int best = 0;

        // Try taking X piles where 1 <= X <= 2M
        for (int x = 1; x <= 2 * m; x++) {
            // Opponent will then play from i + x with updated M
            int opponentGets = dfs(i + x, Math.max(m, x), piles);

            // Current player's stones = total remaining - opponent's best
            int currentGets = suffix[i] - opponentGets;

            // Maximize current player's result
            best = Math.max(best, currentGets);
        }

        // Save and return result
        memo[i][m] = best;
        return best;
    }
}
