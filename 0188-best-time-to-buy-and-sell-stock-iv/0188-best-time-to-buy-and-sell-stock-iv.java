class Solution {
    public int maxProfit(int k, int[] prices) {
        // If there are no prices or no transactions allowed, profit is 0
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        // Store number of days
        int n = prices.length;

        // If k is large enough, this becomes the unlimited transactions case
        if (k >= n / 2) {
            int profit = 0;

            // Add every positive difference
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        // prev[d] = max profit up to day d using at most (t - 1) transactions
        int[] prev = new int[n];

        // Run DP for each transaction from 1 to k
        for (int t = 1; t <= k; t++) {
            // curr[d] = max profit up to day d using at most t transactions
            int[] curr = new int[n];

            // Best value of (previous profit - buy price) seen so far
            int maxDiff = -prices[0];

            // Start from day 1 because day 0 profit is always 0
            for (int d = 1; d < n; d++) {
                // Option 1: do nothing today
                // Option 2: sell today using the best earlier buy
                curr[d] = Math.max(curr[d - 1], prices[d] + maxDiff);

                // Update best earlier buy opportunity
                maxDiff = Math.max(maxDiff, prev[d] - prices[d]);
            }

            // Move current row to previous for next transaction
            prev = curr;
        }

        // Final answer = max profit on last day with at most k transactions
        return prev[n - 1];
    }
}
