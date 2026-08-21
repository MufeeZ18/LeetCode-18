class Solution {
    public int numDecodings(String s) {
        // If string is empty or starts with 0, no valid decoding exists
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // prev2 = number of ways to decode up to i-2
        int prev2 = 1;

        // prev1 = number of ways to decode up to i-1
        int prev1 = 1;

        // Traverse the string starting from index 1
        for (int i = 1; i < s.length(); i++) {
            // curr stores number of ways to decode up to current index
            int curr = 0;

            // If current character is not '0', it can be decoded alone
            if (s.charAt(i) != '0') {
                curr += prev1;
            }

            // Build the two-digit number using previous and current character
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');

            // If two-digit number is valid, add ways from i-2
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            // Shift the window forward for next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        // prev1 now holds the total number of decoding ways
        return prev1;
    }
}
