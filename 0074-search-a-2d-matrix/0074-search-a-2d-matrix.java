class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get number of rows
        int m = matrix.length;
        
        // Get number of columns
        int n = matrix[0].length;
        
        // Binary search range over virtual 1D array
        int left = 0;
        int right = m * n - 1;
        
        // Standard binary search
        while (left <= right) {
            // Find middle index
            int mid = left + (right - left) / 2;
            
            // Convert 1D index to 2D row index
            int row = mid / n;
            
            // Convert 1D index to 2D column index
            int col = mid % n;
            
            // Get the current middle value from matrix
            int value = matrix[row][col];
            
            // If target is found, return true
            if (value == target) {
                return true;
            }
            // If current value is smaller, search right half
            else if (value < target) {
                left = mid + 1;
            }
            // If current value is larger, search left half
            else {
                right = mid - 1;
            }
        }
        
        // Target not found
        return false;
    }
}
