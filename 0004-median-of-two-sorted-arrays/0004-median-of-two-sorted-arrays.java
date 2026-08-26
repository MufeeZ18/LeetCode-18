class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Store lengths of both arrays
        int m = nums1.length;
        int n = nums2.length;

        // Binary search range on smaller array
        int low = 0;
        int high = m;

        // Total elements needed on the left side of partition
        int leftSize = (m + n + 1) / 2;

        // Binary search to find correct partition
        while (low <= high) {
            // Partition index for nums1
            int cut1 = low + (high - low) / 2;

            // Partition index for nums2
            int cut2 = leftSize - cut1;

            // Left max and right min for nums1
            int maxLeft1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int minRight1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            // Left max and right min for nums2
            int maxLeft2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int minRight2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // Check if partition is valid
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is even, median is average of two middle values
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } 
                // If total length is odd, median is max of left side
                else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            }
            // Move left if nums1 left part is too big
            else if (maxLeft1 > minRight2) {
                high = cut1 - 1;
            }
            // Move right if nums2 left part is too big
            else {
                low = cut1 + 1;
            }
        }

        // This line should never be reached for valid input
        return 0.0;
    }
}
