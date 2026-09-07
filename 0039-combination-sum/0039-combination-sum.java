class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Final list to store all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Current combination being built
        List<Integer> path = new ArrayList<>();

        // Start backtracking from index 0
        backtrack(candidates, target, 0, path, result);

        // Return all collected combinations
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> path, List<List<Integer>> result) {

        // If target becomes exactly 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(path)); // Add a copy of current path
            return;
        }

        // Try each candidate starting from 'start' to avoid duplicate orderings
        for (int i = start; i < candidates.length; i++) {
            // If current candidate is larger than remaining target, skip this path
            if (candidates[i] > target) {
                continue;
            }

            // Choose the current candidate
            path.add(candidates[i]);

            // Recur with reduced target
            // Pass i again because same element can be reused unlimited times
            backtrack(candidates, target - candidates[i], i, path, result);

            // Undo the choice to explore next possibilities
            path.remove(path.size() - 1);
        }
    }
}
