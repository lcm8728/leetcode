class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int acc = 0;
        int before = 0;
        int start = 0;
        for(int i = 0; i < n; ++i) {
            acc += gas[i] - cost[i];
            if(acc < 0) {
                before += acc;
                acc = 0;
                start = i + 1;
            }
        }
        
        return acc + before >= 0 ? start : -1;
    }
}