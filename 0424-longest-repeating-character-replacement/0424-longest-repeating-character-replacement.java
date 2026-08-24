class Solution {
    public int characterReplacement(String s, int k) {
        // Array to store frequency of each uppercase English letter
        int[] freq = new int[26];
        
        // Left pointer of the sliding window
        int left = 0;
        
        // Stores the maximum frequency of a single character in the window
        int maxFreq = 0;
        
        // Stores the final answer
        int maxLen = 0;

        // Expand the window using the right pointer
        for (int right = 0; right < s.length(); right++) {
            // Get the index of the current character
            int index = s.charAt(right) - 'A';
            
            // Increase frequency of the current character
            freq[index]++;
            
            // Update maxFreq if current character frequency becomes larger
            maxFreq = Math.max(maxFreq, freq[index]);

            // Current window size is (right - left + 1)
            // If replacements needed are more than k, shrink the window
            while ((right - left + 1) - maxFreq > k) {
                // Remove the left character from the window frequency
                freq[s.charAt(left) - 'A']--;
                
                // Move left pointer forward to shrink the window
                left++;
            }

            // Update the maximum valid window length found so far
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the longest valid substring length
        return maxLen;
    }
}
