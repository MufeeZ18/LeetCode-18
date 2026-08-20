class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes
        if (x < 0) {
            return false;
        }

        // Numbers ending with 0 cannot be palindrome unless the number is 0
        if (x != 0 && x % 10 == 0) {
            return false;
        }

        // This will store the reversed second half of the number
        int reversedHalf = 0;

        // Reverse digits until reversedHalf becomes >= remaining half
        while (x > reversedHalf) {
            // Take the last digit of x and add it to reversedHalf
            reversedHalf = reversedHalf * 10 + x % 10;

            // Remove the last digit from x
            x = x / 10;
        }

        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit ignored)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}