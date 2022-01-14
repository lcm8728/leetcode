class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        for(; i >= 0; --i) {
            if(nums[i] < nums[i + 1]) {
                switchWithNextBigger(nums, i);
                break;
            }
        }
        
        reverse(nums, i + 1, n - 1);
    }
    
    private void switchWithNextBigger(int[] nums, int current) {
        for(int i = nums.length - 1; i > current; --i) {
            if(nums[current] < nums[i]) {
                swap(nums, current, i);
                return;
            }
        }
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