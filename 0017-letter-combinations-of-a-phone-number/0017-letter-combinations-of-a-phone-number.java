import java.util.ArrayList; // Stores the results.
import java.util.List;      // Provides the return type.

class Solution {
    // Each index represents a digit; 0 and 1 have no letters.
    private final String[] letters = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>(); // Collect completed combinations.
        if (digits == null || digits.isEmpty()) return result; // Handle empty input.
        backtrack(digits, 0, new StringBuilder(), result); // Start at the first digit.
        return result; // Return every combination.
    }

    private void backtrack(String digits, int index, StringBuilder path,
                           List<String> result) {
        if (index == digits.length()) { // All digits have a chosen letter.
            result.add(path.toString()); // Save the completed combination.
            return;
        }

        String choices = letters[digits.charAt(index) - '0']; // Get this digit's letters.
        for (char letter : choices.toCharArray()) { // Try each possible letter.
            path.append(letter); // Choose.
            backtrack(digits, index + 1, path, result); // Explore the next digit.
            path.deleteCharAt(path.length() - 1); // Undo the choice.
        }
    }
}
