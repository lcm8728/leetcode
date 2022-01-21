class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;    
        Arrays.sort(nums);
        
        int diff = nums[n - 1] - nums[0];
        for(int i = 0; i < n - 1; ++i) {
            int left = nums[i] + k;
            int right = nums[i + 1] - k;
            int low = Math.min(nums[0] + k, right);
            int high = Math.max(nums[n - 1] - k, left);
            diff = Math.min(diff, high - low);
        }
        
        return diff;
    }
}