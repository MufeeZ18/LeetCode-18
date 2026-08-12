class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the end of the string to find the rightmost odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            
            // Get the current character
            char ch = num.charAt(i);
            
            // Check if the digit is odd
            if ((ch - '0') % 2 == 1) {
                
                // Return the substring from start to this odd digit
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return empty string
        return "";
    }
}
