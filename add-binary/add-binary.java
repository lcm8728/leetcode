class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int longer = Math.max(lenA, lenB);
        int up = 0;
        
        for(int i = 1; i <= longer ; ++i) {
            char charA = charAt(a, lenA - i);
            char charB = charAt(b, lenB - i);
            int sum = add(charA, charB, up);
            up = sum / 2;
            sb.append((char)(sum % 2 + '0'));
        }
        
        if(up == 1) sb.append('1');
        sb.reverse();
        return sb.toString();
    }
    
    private char charAt(String s, int index) {
        if(index < 0) return '0';
        else return s.charAt(index);
    }
    
    private int add(char a, char b, int up) {
        if(a == '0' && b == '0') return 0 + up;
        if(a == '1' && b == '1') return 2 + up;
        return 1 + up;
    }
}