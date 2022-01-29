class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] histogram = new int[m];
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                histogram[j] = matrix[i][j] == '0' ? 0 : histogram[j] + 1;
            }
            max = Math.max(max, findMaximumSquare(histogram));
        }
        
        return max;
    }
    
    private int findMaximumSquare(int[] hist) {
        int n = hist.length;
        int max = 0;
        Stack<int[]> stk = new Stack<>();
        
        for(int i = 0; i < n; ++i) {
            int leftEnd = i;
            while(!stk.isEmpty() && stk.peek()[1] > hist[i]) {
                int[] bar = stk.pop();
                int left = bar[0];
                int height = bar[1];
                
                max = Math.max(max, (i - left) * height);
                leftEnd = left;
            }
            stk.push(new int[] { leftEnd, hist[i] });
        }
        
        while(!stk.isEmpty()) {
            int[] bar = stk.pop();
            int left = bar[0];
            int height = bar[1];

            max = Math.max(max, (n - left) * height);
        }
        
        return max;
    }
}