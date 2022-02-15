class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        // sort intervals
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        
        // merge
        List<int[]> ans = new ArrayList<>();
        for(int i = 1; i < n; ++i) {
            if(intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else {
                ans.add(new int[] { intervals[i - 1][0], intervals[i - 1][1] } );
            }
        }
        
        // list to array
        ans.add(new int[] { intervals[n - 1][0], intervals[n - 1][1] } );
        return ans.toArray(new int[ans.size()][2]);
    }
}