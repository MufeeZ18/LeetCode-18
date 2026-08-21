class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Create an array to store only the current row
        int[] row = new int[rowIndex + 1];
        
        // First element of Pascal's Triangle is always 1
        row[0] = 1;

        // Build each row from 1 to rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            
            // Update from right to left to avoid overwriting needed values
            for (int j = i; j >= 1; j--) {
                row[j] = row[j] + row[j - 1];
            }
        }

        // Convert the array into a List<Integer> for the answer
        List<Integer> result = new ArrayList<>();
        for (int num : row) {
            result.add(num);
        }

        // Return the required row
        return result;
    }
}
