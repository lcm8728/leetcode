class Solution {    
    public int findTargetSumWays(int[] nums, int target) {
        return recursive(nums, 0, target, new HashMap<>());
    }
    
    private int recursive(int[] nums, int curIdx, int target, HashMap<Integer, Integer> cache) {
        int key = 10000 * curIdx + target;
        
        if(cache.containsKey(key)) return cache.get(key);
        if(curIdx == nums.length) return target == 0 ? 1 : 0;
        
        int value = recursive(nums, curIdx + 1, target + nums[curIdx], cache)
            + recursive(nums, curIdx + 1, target - nums[curIdx], cache);
        
        cache.put(key, value);
        return value;
    }
}