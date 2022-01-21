class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int acc = 0;
        int start = -1;
        int n = gas.length;
        int[] cstSum = new int[n];
        
        for(int i = 0; i < n; ++i) {
            int spent = gas[i] - cost[i];

            cstSum[i] = spent;
            if(i > 0) cstSum[i] += cstSum[i - 1];
            
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