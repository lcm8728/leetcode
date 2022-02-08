class Solution {
    int UP = 0;
    int DOWN = 1;
    int LEFT = 2;
    int RIGHT = 3;
    int[][] DIRECTIONS = { {-1, 0},{1, 0},{0, -1},{0, 1} };
    
    public int orderOfLargestPlusSign(int n, int[][] mines) {    
        int[][][] dp = new int[n + 2][n + 2][4];
        int max = 0;
        
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= n; ++j)
                for(int k = 0; k < 4; ++k)
                    dp[i][j][k] = -1;
        
        for(int i = 0; i < mines.length; ++i)
            for(int j = 0; j < 4; ++j)
                dp[mines[i][0] + 1][mines[i][1] + 1][j] = 0;
                    
        for(int i = 1; i <= n; ++i)
            for(int j = 1; j <= n; ++j)
                max = Math.max(max, getLen(i, j, dp, mines));
        
        return max;
    }
    
    private int getLen(int row, int col, int[][][] dp, int[][] mines) {
        int max = Integer.MAX_VALUE;
        
        for(int i = 0; i < 4; ++i) {
            max = Math.min(max, getLen(row, col, UP, dp, mines));
            max = Math.min(max, getLen(row, col, DOWN, dp, mines));
            max = Math.min(max, getLen(row, col, LEFT,  dp, mines));
            max = Math.min(max, getLen(row, col, RIGHT,  dp, mines));
        }
        
        return max;
    }
    
    private int getLen(int row, int col, int dir, int[][][] dp, int[][] mines) {
        if(dp[row][col][dir] > -1) {
            return dp[row][col][dir];
        }
        
        int nextRow = row + DIRECTIONS[dir][0];
        int nextCol = col + DIRECTIONS[dir][1];
        dp[row][col][dir] = 1 + getLen(nextRow, nextCol, dir, dp, mines);
        
        return dp[row][col][dir];
    }
}