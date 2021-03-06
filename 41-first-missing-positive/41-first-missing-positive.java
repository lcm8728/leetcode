class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i = 0; i < n; ++i) {
            while(1 <= nums[i] && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        
        for(int i = 0; i < n; ++i) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}