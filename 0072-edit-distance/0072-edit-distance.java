class Solution {
    public int minDistance(String word1, String word2) {
        // Use the shorter string as columns to minimize memory.
        if (word1.length() < word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int m = word1.length(); // Number of source characters.
        int n = word2.length(); // Number of target characters.
        int[] dp = new int[n + 1]; // Store one row of edit distances.

        // An empty source needs j insertions to build a target prefix.
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        // Process each source prefix.
        for (int i = 1; i <= m; i++) {
            int diagonal = dp[0]; // Previous row's diagonal value.
            dp[0] = i; // An empty target requires i deletions.

            // Calculate the distance for each target prefix.
            for (int j = 1; j <= n; j++) {
                int above = dp[j]; // Save the value before overwriting.

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = diagonal; // Matching characters cost nothing.
                } else {
                    dp[j] = 1 + Math.min(
                        diagonal, // Replace the source character.
                        Math.min(
                            above,    // Delete the source character.
                            dp[j - 1] // Insert the target character.
                        )
                    );
                }

                diagonal = above; // Preserve diagonal for the next column.
            }
        }

        return dp[n]; // Minimum edits between the complete strings.
    }
}
