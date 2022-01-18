class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < (n - 1) - i ; ++j) {
                int dist = (n - 1) - i - j;
                swap(matrix, i, j, i + dist, j + dist);
            }
        }
        
        for(int i = 0; i < n / 2; ++i) {
            for(int j = 0; j < n ; ++j) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }
    
    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int t = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = t;
    }
}