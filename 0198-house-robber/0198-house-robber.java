class Solution {
    public int rob(int[] nums) {
        int prev2 = 0; // Maximum money through two houses ago
        int prev1 = 0; // Maximum money through the previous house

        for (int money : nums) {
            // Choose between robbing this house and skipping it
            int current = Math.max(prev2 + money, prev1);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}