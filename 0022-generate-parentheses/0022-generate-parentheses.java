class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(); // Store valid combinations.
        backtrack(n, 0, 0, new StringBuilder(), result); // Start with an empty string.
        return result; // Return all combinations.
    }

    private void backtrack(int n, int open, int close,
                           StringBuilder current, List<String> result) {
        if (current.length() == 2 * n) { // A complete valid combination.
            result.add(current.toString()); // Save it.
            return; // Stop this path.
        }

        if (open < n) { // We can still add an opening parenthesis.
            current.append('('); // Choose '('.
            backtrack(n, open + 1, close, current, result); // Explore.
            current.deleteCharAt(current.length() - 1); // Undo the choice.
        }

        if (close < open) { // Closing now keeps the prefix valid.
            current.append(')'); // Choose ')'.
            backtrack(n, open, close + 1, current, result); // Explore.
            current.deleteCharAt(current.length() - 1); // Undo the choice.
        }
    }
}
