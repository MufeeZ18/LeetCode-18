class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Store the maximum pile size to define the upper bound of binary search
        int maxPile = 0;
        
        // Find the largest pile
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        // Lowest possible speed
        int left = 1;
        
        // Highest possible speed
        int right = maxPile;
        
        // Store the best valid answer found so far
        int answer = maxPile;

        // Binary search on eating speed
        while (left <= right) {
            // Find the middle speed
            int mid = left + (right - left) / 2;
            
            // Track total hours needed at this speed
            long hoursNeeded = 0;

            // Calculate total hours for all piles
            for (int pile : piles) {
                // Ceiling division: ceil(pile / mid)
                hoursNeeded += (pile + mid - 1) / mid;
            }

            // If Koko can finish within h hours
            if (hoursNeeded <= h) {
                // mid is a valid answer
                answer = mid;
                
                // Try to find a smaller valid speed
                right = mid - 1;
            } else {
                // mid is too slow, move to higher speeds
                left = mid + 1;
            }
        }

        // Return the minimum valid speed
        return answer;
    }
}
