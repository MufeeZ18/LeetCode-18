import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If lengths are different, strings cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Map each character in s to its mapped character in t
        HashMap<Character, Character> map = new HashMap<>();

        // Track which characters in t are already mapped to
        HashSet<Character> used = new HashSet<>();

        // Traverse both strings character by character
        for (int i = 0; i < s.length(); i++) {
            // Get current characters from both strings
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If c1 already has a mapping
            if (map.containsKey(c1)) {
                // The existing mapping must match c2
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                // If c2 is already used by some other character, invalid
                if (used.contains(c2)) {
                    return false;
                }

                // Store the new mapping from c1 to c2
                map.put(c1, c2);

                // Mark c2 as already used
                used.add(c2);
            }
        }

        // All mappings were consistent
        return true;
    }
}
