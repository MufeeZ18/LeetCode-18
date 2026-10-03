class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();              // Length of the text
        int m = needle.length();                // Length of the pattern
        int[] lps = new int[m];                 // Reusable prefix lengths

        for (int i = 1, len = 0; i < m;) {     // Build the LPS array
            if (needle.charAt(i) == needle.charAt(len)) {
                lps[i++] = ++len;              // Extend the matching prefix
            } else if (len > 0) {
                len = lps[len - 1];            // Try a shorter prefix
            } else {
                lps[i++] = 0;                  // No matching prefix
            }
        }

        for (int i = 0, j = 0; i < n;) {       // Scan haystack with i, needle with j
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;                           // Advance in haystack
                j++;                           // Advance in needle
                if (j == m) return i - m;      // First complete match
            } else if (j > 0) {
                j = lps[j - 1];                // Reuse the matched prefix
            } else {
                i++;                           // No partial match to reuse
            }
        }

        return -1;                              // Needle was not found
    }
}
