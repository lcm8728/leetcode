class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            charMap.put(s.charAt(i), i);
        }
        
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = 0;
        int atLeast = 0;
        
        while(r < s.length()) {
            atLeast = Math.max(atLeast, charMap.get(s.charAt(r)));
            
            if(r == atLeast) {
                ans.add(r - l + 1);
                l = r + 1;
            }
            
            r++;
        }
        
        return ans;
    }
}