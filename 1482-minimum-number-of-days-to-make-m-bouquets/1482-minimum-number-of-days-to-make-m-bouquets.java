class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Total flowers needed
        long needed = (long) m * k;
        
        // If total flowers needed are more than available flowers, impossible
        if (needed > bloomDay.length) {
            return -1;
        }

        // Find minimum and maximum bloom day
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        // Variable to store the minimum valid day
        int ans = -1;

        // Binary search on the answer space
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if we can make m bouquets by 'mid' days
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;        // mid is a valid answer
                high = mid - 1;   // try to find a smaller valid day
            } else {
                low = mid + 1;    // need more days
            }
        }

        return ans;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        // Count consecutive bloomed flowers
        int flowers = 0;

        // Count total bouquets formed
        int bouquets = 0;

        for (int bloom : bloomDay) {
            // If flower has bloomed by 'day'
            if (bloom <= day) {
                flowers++;

                // If we got k adjacent flowers, form one bouquet
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // reset because flowers can be used only once
                }
            } else {
                // Break adjacency if flower has not bloomed
                flowers = 0;
            }
        }

        // Return whether we can make at least m bouquets
        return bouquets >= m;
    }
}
