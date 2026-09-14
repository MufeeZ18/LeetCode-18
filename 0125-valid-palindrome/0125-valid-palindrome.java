class Solution {
    public boolean isPalindrome(String s) {
        // Pointer starting from the left
        int left = 0;
        
        // Pointer starting from the right
        int right = s.length() - 1;

        // Keep checking until pointers meet
        while (left < right) {
            
            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Convert both characters to lowercase for case-insensitive comparison
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            // If characters do not match, it's not a palindrome
            if (leftChar != rightChar) {
                return false;
            }

            // Move both pointers inward
            left++;
            right--;
        }

        // If all valid characters matched, it is a palindrome
        return true;
    }
}
