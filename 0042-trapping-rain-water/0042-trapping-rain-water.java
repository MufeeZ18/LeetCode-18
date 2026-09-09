class Solution {
    public int trap(int[] height) {
        // Pointer starting from the left side
        int left = 0;
        
        // Pointer starting from the right side
        int right = height.length - 1;
        
        // Stores the maximum height seen so far from the left
        int leftMax = 0;
        
        // Stores the maximum height seen so far from the right
        int rightMax = 0;
        
        // Final answer for total trapped water
        int water = 0;

        // Process until both pointers meet
        while (left < right) {
            
            // If left bar is smaller, process left side
            if (height[left] < height[right]) {
                
                // If current left bar is taller than or equal to leftMax,
                // update leftMax because no water can be trapped here
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Otherwise, water trapped is leftMax - current height
                    water += leftMax - height[left];
                }
                
                // Move left pointer inward
                left++;
            } else {
                
                // If current right bar is taller than or equal to rightMax,
                // update rightMax because no water can be trapped here
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Otherwise, water trapped is rightMax - current height
                    water += rightMax - height[right];
                }
                
                // Move right pointer inward
                right--;
            }
        }

        // Return total trapped water
        return water;
    }
}
