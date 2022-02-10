class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hm.put(0, -1);
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            sum %= k;
            if(hm.containsKey(sum) && hm.get(sum) < i - 1) {
                return true;
            }
            hm.put(sum, hm.getOrDefault(sum, i)); 
        }
        
        return false;
    }
}