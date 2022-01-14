class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        for(; i >= 0; --i) {
            if(switchWithNextBigger(nums, i)) {
                break;
            }
        }
        
        reverse(nums, i + 1, n - 1);
    }
    
    private boolean switchWithNextBigger(int[] nums, int current) {
        for(int i = nums.length - 1; i > current; --i) {
            if(nums[current] < nums[i]) {
                swap(nums, current, i);
                return true;
            }
        }
        
        return false;
    }
    
    private void reverse(int[] nums, int from, int to) {
        for(int i = from; i < (from + to + 1) / 2; ++i) {
            swap(nums, i, to - (i - from));
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}