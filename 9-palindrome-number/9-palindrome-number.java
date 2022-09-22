class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int n = str.length();
        
        for (int i = 0; i < n / 2; ++i) {
            if(str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }
}