class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        for(; i >= 0; --i) {
            int t = 101;
            int ti = -1;
            
            for(int j = i + 1; j < n; ++j) {
                if(nums[i] < nums[j] && nums[j] < t) {
                    ti = j;
                    t = nums[j];
                }
            }
            
            if(t < 101) {
                nums[ti] = nums[i];
                nums[i] = t;
                break;
            }
        }
        
        sort(nums, i + 1, n - 1);
    }
    
    private void sort(int[] nums, int from, int to) {
        int n = nums.length;
        int t = 0;
        
        for(int i = from; i < n - 1; ++i) {
            for(int j = i; j < n; ++j) {
                if(nums[i] > nums[j]) {
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
    }
}