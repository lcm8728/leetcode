class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        
        for(int i = 1; i < n + 1; ++i) {
            dp[i] = false;
            for(int j = 1; j * j <= i; ++j) {
                if(dp[i - j * j] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}