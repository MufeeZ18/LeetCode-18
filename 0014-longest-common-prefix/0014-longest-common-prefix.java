class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Handle empty or null input
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume first string is the common prefix
        String prefix = strs[0];

        // Compare prefix with each string
        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until current string starts with it
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return final common prefix
        return prefix;
    }
}
