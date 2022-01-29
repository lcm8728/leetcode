class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int[] leftEnd = new int[n];
        int[] rightEnd = new int[n];
        
        for(int i = 1; i < n; ++i) {
            int left = i;
            while(left > 0 && heights[left - 1] >= heights[i]) 
                left = leftEnd[left - 1];
            leftEnd[i] = left;
        }

        rightEnd[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; --i) {
            int right = i;
            while(right < n - 1 && heights[right + 1] >= heights[i])
                right = rightEnd[right + 1];
            rightEnd[i] = right;
        }
        
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, (rightEnd[i] - leftEnd[i] + 1) * heights[i]);
        }
        
        return max;
    }
}