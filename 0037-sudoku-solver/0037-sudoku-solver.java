class Solution {
    // Track which numbers are already used in each row
    boolean[][] rows = new boolean[9][10];
    
    // Track which numbers are already used in each column
    boolean[][] cols = new boolean[9][10];
    
    // Track which numbers are already used in each 3x3 box
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // Pre-fill the tracking arrays using the existing board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells
                if (board[r][c] == '.') continue;

                // Convert char digit to int
                int num = board[r][c] - '0';

                // Get box index for current cell
                int box = (r / 3) * 3 + (c / 3);

                // Mark this number as used
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[box][num] = true;
            }
        }

        // Start backtracking from the first cell
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int r, int c) {
        // If we reached row 9, the board is solved
        if (r == 9) return true;

        // If we reached end of current row, move to next row
        if (c == 9) return solve(board, r + 1, 0);

        // If cell is already filled, move to next column
        if (board[r][c] != '.') return solve(board, r, c + 1);

        // Find which 3x3 box this cell belongs to
        int box = (r / 3) * 3 + (c / 3);

        // Try placing digits 1 to 9
        for (int num = 1; num <= 9; num++) {
            // If digit already used, skip it
            if (rows[r][num] || cols[c][num] || boxes[box][num]) {
                continue;
            }

            // Place the digit on board
            board[r][c] = (char) (num + '0');

            // Mark digit as used
            rows[r][num] = true;
            cols[c][num] = true;
            boxes[box][num] = true;

            // Recurse to solve remaining board
            if (solve(board, r, c + 1)) {
                return true;
            }

            // Backtrack: remove the digit from board
            board[r][c] = '.';

            // Unmark digit as used
            rows[r][num] = false;
            cols[c][num] = false;
            boxes[box][num] = false;
        }

        // No valid digit worked here
        return false;
    }
}
