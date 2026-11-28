import java.util.*;

class Solution {
    public int findMaximizedCapital(
            int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        // Each project stores [required capital, profit].
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Process projects from lowest to highest capital requirement.
        Arrays.sort(projects,
                (a, b) -> Integer.compare(a[0], b[0]));

        // Highest affordable profit stays at the top.
        PriorityQueue<Integer> available =
                new PriorityQueue<>(Comparator.reverseOrder());

        // Points to the next project not yet added to the heap.
        int index = 0;

        for (int selected = 0; selected < k; selected++) {
            // Unlock all projects affordable with current capital.
            while (index < n && projects[index][0] <= w) {
                available.offer(projects[index][1]);
                index++;
            }

            // No affordable project means no further progress.
            if (available.isEmpty()) {
                break;
            }

            // Complete the most profitable affordable project.
            w += available.poll();
        }

        return w;
    }
}
