class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle edge case where matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // Start from the top-right corner
        int row = 0;
        int col = matrix[0].length - 1;

        // Continue while row and col are within bounds
        while (row < matrix.length && col >= 0) {
            // If target is found, return true
            if (matrix[row][col] == target) {
                return true;
            }
            // If current value is greater than target, move left
            else if (matrix[row][col] > target) {
                col--;
            }
            // If current value is smaller than target, move down
            else {
                row++;
            }
        }

        // Target not found
        return false;
    }
}
