class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int flips = 0;
        int max = 0;
        
        while (r < nums.length) {
            if (nums[r] == 1) {
                max = Math.max(max, r - l + 1);
                r++;
            }
            
            else if (flips < k) {
                max = Math.max(max, r - l + 1);
                flips++;
                r++;
            }
            
            else {
                if (nums[l] == 0 && 0 < flips && flips <= k) {
                    flips--;
                }
                l++;
                r = Math.max(r, l);
            }
        }
        
        return max;
    }
}