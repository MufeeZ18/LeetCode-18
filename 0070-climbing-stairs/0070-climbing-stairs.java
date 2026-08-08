class Solution {
    public int climbStairs(int n) {
        // If there is only 1 step, only 1 way exists
        if (n == 1) {
            return 1;
        }

        // Ways to reach step 1
        int first = 1;

        // Ways to reach step 2
        int second = 2;

        // Build the answer from step 3 up to step n
        for (int i = 3; i <= n; i++) {
            // Current step ways = previous step + two steps before
            int current = first + second;

            // Move first forward
            first = second;

            // Move second forward
            second = current;
        }

        // For n >= 2, second holds the final answer
        return second;
    }
}
