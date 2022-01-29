class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int drops = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        for(int i = 0; i < n; ++i) {
            leftMax[i] = i > 0 ? Math.max(leftMax[i - 1], height[i]) : height[i];
        }
        for(int i = n - 1; i >= 0; --i) {
            rightMax[i] = i < n - 1 ? Math.max(rightMax[i + 1], height[i]) : height[i];
        }
        for(int i = 0; i < n; ++i) {
            if(leftMax[i] > height[i] && rightMax[i] > height[i]) {
                drops += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        
        return drops;
    }
}