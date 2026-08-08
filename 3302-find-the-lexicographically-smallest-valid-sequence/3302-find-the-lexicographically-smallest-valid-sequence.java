class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // right[j] = an index in word1 where word2[j] can be placed,
        // while still allowing word2[j..m-1] to match exactly as a subsequence
        int[] right = new int[m];
        for (int x = 0; x < m; x++) {
            right[x] = -1; // default means exact suffix match is not possible
        }

        int i = n - 1;
        int j = m - 1;

        // Build right[] by matching from the end
        while (i >= 0 && j >= 0) {
            // If characters match, store this index for word2[j]
            if (word1.charAt(i) == word2.charAt(j)) {
                right[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];
        int p = 0; // pointer in word1
        boolean usedMismatch = false;

        // Greedily build lexicographically smallest answer
        for (j = 0; j < m; j++) {
            boolean found = false;

            while (p < n) {
                char c1 = word1.charAt(p);
                char c2 = word2.charAt(j);

                // Case 1: exact character match, always best to take earliest one
                if (c1 == c2) {
                    ans[j] = p;
                    p++;
                    found = true;
                    break;
                }

                // Case 2: use the one allowed mismatch here
                // Only valid if the remaining suffix can still match exactly
                boolean canUseMismatch = !usedMismatch &&
                        (j == m - 1 || (right[j + 1] != -1 && p < right[j + 1]));

                if (canUseMismatch) {
                    ans[j] = p;
                    usedMismatch = true;
                    p++;
                    found = true;
                    break;
                }

                // Otherwise skip this index and keep searching
                p++;
            }

            // If we could not place word2[j], no valid sequence exists
            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}
