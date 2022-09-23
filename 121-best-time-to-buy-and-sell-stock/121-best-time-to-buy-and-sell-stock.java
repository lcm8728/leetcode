class Solution {
    public int maxProfit(int[] prices) {
        int[] mins = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            mins[i] = min;
        }
        
        int maxProfit = 0;
        for(int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - mins[i - 1]);
        }
        
        return maxProfit;
    }
}