class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        Stack<int[]> stk = new Stack<>();
        
        for(int i = 0; i < n; ++i) {
            int leftEnd = i;
            while(!stk.isEmpty() && stk.peek()[1] > heights[i]) {
                int[] prev = stk.pop();
                int prevIndex = prev[0];
                int prevHeight = prev[1];

                max = Math.max(max, (i - prevIndex) * prevHeight);
                leftEnd = prevIndex;
            }
            stk.push(new int[]{ leftEnd, heights[i] });
        }
        
        while(!stk.isEmpty()) {
            int[] prev = stk.pop();
            int index = prev[0];
            int height = prev[1];
            
            max = Math.max(max, (n - index) * height);
        }
        
        return max;
    }
}