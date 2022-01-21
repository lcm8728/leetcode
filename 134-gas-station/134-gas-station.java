class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] cstSum = new int[n];
        
        cstSum[0] = gas[0] - cost[0];
        for(int i = 1; i < n; ++i) {
            cstSum[i] = cstSum[i - 1];
            cstSum[i] += gas[i] - cost[i];
        }
        
        int acc = 0;
        int start = -1;
        for(int i = 0; i < n; ++i) {
            int spent = gas[i] - cost[i];
            if(acc + spent >= 0 && acc == 0) {
                acc = spent;
                start = i;
            } else if(acc + spent >= 0) {
                acc += spent;
            } else {
                acc = 0;
                start = -1;
            }
        }
        
        if(start > 0 && cstSum[start - 1] + acc < 0) {
            start = -1;
        }
        
        return start;
    }
}