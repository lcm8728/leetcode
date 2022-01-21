class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int up = 1;
        
        for(int i = n - 1; i > -1; --i) {
            if(digits[i] + up == 10) {
                up = 1;
                digits[i] = 0;
            } else {
                digits[i] += up;
                return digits;
            }
        }
        
        int[] ret = new int[n + 1];
        ret[0] = 1;
        for(int i = 1; i < n + 1; ++i) {
            ret[i] = digits[i - 1];
        }
        
        return ret;
    }
}