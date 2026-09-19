import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map sorted-character key to its anagram group
        Map<String, List<String>> groups = new HashMap<>();

        // Process each input string
        for (String word : strs) {
            // Convert word to characters so it can be sorted
            char[] chars = word.toCharArray();

            // Sort characters to create a common key for anagrams
            Arrays.sort(chars);

            // Convert sorted characters back to a String key
            String key = new String(chars);

            // Create the group if absent, then add current word
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(word);
        }

        // Return all grouped anagram lists
        return new ArrayList<>(groups.values());
    }
}
