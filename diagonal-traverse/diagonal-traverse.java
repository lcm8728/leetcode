class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[] ret = new int[n * m];
        int row = 0;
        int col = 0;
        int idx = 0;
        boolean even = true;
        while(isValid(n, m, row, col)) {
            ret[idx++] = mat[row][col];
            
            int nextRow = even ? row - 1 : row + 1;
            int nextCol = even ? col + 1 : col - 1;
            if(!isValid(n, m, nextRow, nextCol)) {
                if(even) {
                    nextRow = col + 1 == m ? row + 1 : row;
                    nextCol = col + 1 == m ? col : col + 1;
                    even = false;
                } else {
                    nextRow = row + 1 == n ? row : row + 1;
                    nextCol = row + 1 == n ? col + 1 : col;
                    even = true;
                }
            }
            row = nextRow;
            col = nextCol;
        }
        
        return ret;
    }
    
    
    
    private boolean isValid(int n, int m, int i, int j) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }
}