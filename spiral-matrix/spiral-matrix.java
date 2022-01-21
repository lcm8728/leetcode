class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        
        int visited = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        while(ret.size() < n * m) {
            ret.add(matrix[row][col]);
            matrix[row][col] = visited;
            
            int nextRow = row + moves[direction][0];
            int nextCol = col + moves[direction][1];
            if(!valid(matrix, nextRow, nextCol)) {
                direction = (direction + 1) % 4;
                nextRow = row + moves[direction][0];
                nextCol = col + moves[direction][1];
            }
            
            row = nextRow;
            col = nextCol;
        }
        
        return ret;
    }

    private boolean valid(int[][] matrix, int row, int col) {
        return 0 <= row && row < matrix.length 
            && 0 <= col && col < matrix[0].length 
            && matrix[row][col] != Integer.MIN_VALUE;
    }
}