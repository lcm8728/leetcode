class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sums = new HashMap<>();
        
        sums.put(0, 1);
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            if(sums.containsKey(sum - k)) {
                count += sums.get(sum - k);
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}