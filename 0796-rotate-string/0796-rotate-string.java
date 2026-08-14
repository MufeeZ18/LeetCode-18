class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are different, rotation is impossible
        if (s.length() != goal.length()) {
            return false;
        }

        // Join s with itself so all possible rotations appear as substrings
        String doubled = s + s;

        // If goal exists inside doubled string, then goal is a valid rotation
        return doubled.contains(goal);
    }
}
