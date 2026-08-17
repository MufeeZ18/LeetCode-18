class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Array to store frequency of 26 lowercase English letters
        int[] count = new int[26];

        // Traverse both strings together
        for (int i = 0; i < s.length(); i++) {
            // Increase count for character from s
            count[s.charAt(i) - 'a']++;

            // Decrease count for character from t
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int i = 0; i < 26; i++) {
            // If any count is not zero, strings are not anagrams
            if (count[i] != 0) {
                return false;
            }
        }

        // All counts matched, so strings are anagrams
        return true;
    }
}
