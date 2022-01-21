class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int prev = 0;
        for(int i = 0; i < n; ++i) {
            if(arr[i] - prev > 1) {
                prev += 1;
            } else {
                prev = arr[i];
            }
        }
        
        return prev;
    }
}